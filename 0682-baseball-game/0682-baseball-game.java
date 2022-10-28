class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.peek();
                int sum = num1+num2;
                stack.push(num1);
                stack.push(sum);
            }else if(operations[i].equals("D")){
                int num1 = stack.peek();
                stack.push(num1*2);
            }else if(operations[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}