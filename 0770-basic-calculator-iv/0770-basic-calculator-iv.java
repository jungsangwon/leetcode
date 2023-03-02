class Solution {
    int idx=0;
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        expression=expression.replaceAll("\\(","( ");
        expression=expression.replaceAll("\\)"," )");
        String[] exp = expression.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<evalvars.length; i++){
            map.put(evalvars[i],evalints[i]);
        }
        for(int i=0; i<exp.length; i++){
            if(map.containsKey(exp[i])){
                exp[i] = String.valueOf(map.get(exp[i]));
            }
        }
        return basicCalculatorIV(exp,evalvars,evalints);
    }
    
    public List<String> basicCalculatorIV(String[] exp, String[] evalvars, int[] evalints) {
        List<String> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> before=new ArrayList<>();
        String div="+";
        while(idx<exp.length){
            if(exp[idx].equals("(")){
                idx++;
                List<String> next = basicCalculatorIV(exp,evalvars,evalints);
                if(div.equals("*")){
                    before = multiply(before,next,div);
                }else{
                    list.addAll(before);
                    before.clear();
                    if(div.equals("-")){
                        for(String str : next){
                            before.add("-1*"+str);
                        }
                    }else{
                        before = next;
                    }
                }
            }else if(exp[idx].equals(")")){
                break;
            }else if(exp[idx].equals("+") || exp[idx].equals("*") || exp[idx].equals("-")){
                div = exp[idx];
            }else{
                List<String> now = new ArrayList<>();
                now.add(exp[idx]);
                if(div.equals("*")){
                    before = multiply(before,now,div);
                }else{
                    list.addAll(before);
                    before.clear();
                    if(div.equals("-")){
                        for(String str : now){
                            before.add("-1*"+str);
                        }
                    }else{
                        before = now;
                    }
                }
            }
            idx++;
        }
        list.addAll(before);
        merge(map,list);        
        for(String key : map.keySet()){
            int tmp = map.get(key);
            if(tmp!=0){
                if(key.equals("")){
                    result.add(String.valueOf(tmp));
                }else{
                    result.add(tmp+"*"+key);
                }
            }
        }
        result.sort(new Comparator<>(){
            @Override
            public int compare(String a, String b){
                int check = (int)b.chars().filter(c -> c == '*').count() - (int)a.chars().filter(c -> c == '*').count();
                if(check == 0){
                    String tmp1 = a.substring(a.indexOf("*"));
                    String tmp2 = b.substring(b.indexOf("*"));
                    return tmp1.compareTo(tmp2);
                }else{
                    return check;
                }
            }
        });
        return result;
    }
    
    public List<String> multiply(List<String> a, List<String> b, String div){
        List<String> result = new ArrayList<>();
        for(String str1 : a){
            for(String str2 : b){
                result.add(str1+"*"+str2);
            }
        }
        return result;
    }
    
    public void merge(HashMap<String,Integer> map, List<String> a){
        List<String> key;
        int num=1;
        for(String str : a){
            String k="";
            key = new ArrayList<>();
            String[] tmp = str.split("\\*");
            for(int i=0; i<tmp.length; i++){
                if(isNum(tmp[i])){
                    num *= Integer.parseInt(tmp[i]);
                }else{
                    key.add(tmp[i]);
                }
            }
            if(!key.isEmpty()){
                Collections.sort(key);
                StringBuilder sb = new StringBuilder();
                for(String str1 : key){
                    sb.append(str1+"*");
                }
                k = sb.substring(0,sb.length()-1).toString();
            }
            map.put(k,map.getOrDefault(k,0)+num);
            num=1;
        }
    }
    
    public boolean isNum(String a){
        try{
            Integer.parseInt(a);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}