class Solution {
    public int evalRPN(String[] tokens) {
        Queue<String> qu = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            qu.add(str);
        }
        while(!qu.isEmpty()){
            String tmp = qu.poll();
            if(isNum(tmp)){
                st.push(Integer.parseInt(tmp));
            }else{
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(calculate(num2,num1,tmp));
            }
        }
        
        return st.pop();
    }
    
    public boolean isNum(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public int calculate(int a, int b, String str){
        if(str.equals("+")){
            return a + b;
        }else if(str.equals("-")){
            return a - b; 
        }else if(str.equals("*")){
            return a * b;
        }else{
            return a / b;
        }
    }
}