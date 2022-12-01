class Solution {
    int idx = 0;
    
    public String countOfAtoms(String formula) {
        TreeMap<String,Integer> map = counting(formula);
        // System.out.println("~~~~~~~~~~~~~~~~");
        // for(String key : map.keySet()){
        //     System.out.println(key+" : "+map.get(key));
        // }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            sb.append(key);
            if(map.get(key)!=1){
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
    
    public TreeMap<String,Integer> counting(String formula) {
        TreeMap<String,Integer> map = new TreeMap<>();
        String key="";
        int count=0;
        for(; idx<formula.length(); idx++){
            char now = formula.charAt(idx);
            if(now<='9' && now>='0'){
                count = count*10 + (now-'0');
            }else if(now<='Z' && now>='A'){
                if(key.length()!=0){
                    if(count==0){
                        count=1;
                    }
                    map.put(key,map.getOrDefault(key,0)+count);
                    count = 0;
                }
                key = String.valueOf(now);
            }else if(now<='z' && now>='a'){
                key += now;
            }else if(now=='('){
                if(key.length()!=0){
                    if(count==0){
                        count=1;
                    }
                    map.put(key,map.getOrDefault(key,0)+count);
                    count = 0;
                }
                idx++;
                TreeMap<String,Integer> next = counting(formula);
                // System.out.println("================");
                // for(String n : next.keySet()){
                //     System.out.println(n+" : "+next.get(n));
                // }
                idx++;
                while(idx!=formula.length()){
                    char tmp = formula.charAt(idx);
                    if(tmp<='9' && tmp>='0'){
                        count = count*10 + (tmp-'0');
                    }else{
                        idx--;
                        break;
                    }
                    idx++;
                }
                if(count==0){
                    count=1;
                }
                for(String str : next.keySet()){
                    map.put(str,map.getOrDefault(str,0)+(next.get(str)*count));
                }
                count=0;
                key="";
                if(idx==formula.length()){
                    return map;
                }
            }else{
                if(key.length()!=0){
                    if(count==0){
                        count=1;
                    }
                    map.put(key,map.getOrDefault(key,0)+count);
                }
                return map;
            }
        }
        if(count==0){
            count=1;
        }
        map.put(key,map.getOrDefault(key,0)+count);
        return map;
    }
}