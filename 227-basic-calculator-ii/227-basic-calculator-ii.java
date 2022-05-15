import java.util.StringTokenizer;
class Solution {
    public int calculate(String s) {
        s=s.replaceAll(" ","");
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, "[+-*/]", true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        Stack<String> stack = new Stack<>();
        Queue<String> qu = new LinkedList<>(list);
        while(!qu.isEmpty()){
            String tmp = qu.poll();
            if(tmp.equals("*")){
                int num1 = Integer.parseInt(qu.poll());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1*num2));
            }else if(tmp.equals("/")){
                int num1 = Integer.parseInt(qu.poll());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2/num1));
            }else{
                stack.push(tmp);
            }
        }
        Stack<String> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        stack = new Stack<>();
        while(!stack2.isEmpty()){
            String tmp = stack2.pop();
            if(tmp.equals("-")){
                int num1 = Integer.parseInt(stack2.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2-num1));
            }else if(tmp.equals("+")){
                int num1 = Integer.parseInt(stack2.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2+num1));
            }else{
                stack.push(tmp);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
}