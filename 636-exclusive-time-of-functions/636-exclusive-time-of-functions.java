class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> function = new Stack<>();
        Stack<Integer> start = new Stack<>();
        Stack<Integer> minus = new Stack<>();
        
        for(String str : logs){
            String[] tmp = str.split(":");
            if(tmp[1].equals("start")){
                function.push(Integer.parseInt(tmp[0]));
                start.push(Integer.parseInt(tmp[2]));
                minus.push(0);
            }else{
                int now = Integer.parseInt(tmp[2]) - start.pop() + 1;
                result[function.pop()] += (now-minus.pop());
                if(!minus.isEmpty()){
                    minus.push(minus.pop() + now);
                }
            }
        }
        return result;
    }
}