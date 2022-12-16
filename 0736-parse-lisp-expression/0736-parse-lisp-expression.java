class Solution {
    int i = 1;
    String[] exp;
    public int evaluate(String expression) {
        expression=expression.replaceAll("\\(","( ");
        expression=expression.replaceAll("\\)"," )");
        exp = expression.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        return evaluate(map);
    }
    public int evaluate(HashMap<String,Integer> map) {
        if(exp[i].equals("let")){
            i++;
            return let(map);
        }else if(exp[i].equals("mult")){
            i++;
            return calc(map,"mult");
        }else{
            i++;
            return calc(map,"add");
        }
    }
    
    public int let(HashMap<String,Integer> map){
        // System.out.println("let : "+exp[i]);
        HashMap<String,Integer> next = new HashMap<>(map);
        while(true){
            if(exp[i].equals("(")){
                i++;
                int result = evaluate(next);
                i++;
                return result;
            }else if(exp[i+1].equals(")")){
                String key = exp[i];
                i+=2;
                if(next.containsKey(key)){
                    return next.get(key);
                }else{
                    return Integer.parseInt(key);
                }
            }else{
                if(exp[i+1].equals("(")){
                    String key = exp[i];
                    i+=2;
                    next.put(key,evaluate(next));
                }else{
                     if(next.containsKey(exp[i+1])){
                        next.put(exp[i],next.get(exp[i+1]));
                    }else{
                        next.put(exp[i],Integer.parseInt(exp[i+1]));
                    }
                    i+=2;
                }
            }
        }
    }
    
    public int calc(HashMap<String,Integer> map,String div){
        // System.out.println(div+" : "+exp[i]);
        HashMap<String,Integer> next = new HashMap<>(map);
        int num1;
        int num2;
        if(exp[i].equals("(")){
            i++;
            num1 = evaluate(next);
        }else{
            if(next.containsKey(exp[i])){
                num1 = next.get(exp[i]);
            }else{
                num1 = Integer.parseInt(exp[i]);
            }
            i++;
        }
        if(exp[i].equals("(")){
            i++;
            num2 = evaluate(next);
        }else{
            if(next.containsKey(exp[i])){
                num2 = next.get(exp[i]);
            }else{
                num2 = Integer.parseInt(exp[i]);
            }
            i++;
        }
        i++;
        if(div.equals("mult")){
            // System.out.println("mult : "+num1+" * "+num2+" = "+(num1*num2));
            return num1*num2;
        }else{
            // System.out.println("add : "+num1+" + "+num2+" = "+(num1+num2));
            return num1+num2;
        }
    }
}
