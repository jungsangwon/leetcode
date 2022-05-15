class Solution {
    public int calculate(String s) {
        Queue<Character> qu = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(now!=' '){
                qu.add(now);
            }
        }
        return calculate(qu);
    }
    public int calculate(Queue<Character> qu){
        int result = 0;
        boolean plus = true;
        int tmp = 0;
        while(!qu.isEmpty()){
            char now = qu.poll();
            if(now=='-'){
                result = calculate(result,tmp,plus);
                tmp=0;
                plus = false;
            }else if(now=='+'){
                result = calculate(result,tmp,plus);
                tmp=0;
                plus = true;
            }else if(now=='('){
                result = calculate(result,calculate(qu),plus);
            }else if(now==')'){
                return calculate(result,tmp,plus);
            }else{
                tmp = tmp*10 + Character.getNumericValue(now);
            }
        }
        return calculate(result,tmp,plus);
    }
    
    public int calculate(int num1, int num2, boolean plus){
        if(plus){
            return num1+num2;
        }else{
            return num1-num2;
        }
    }
}