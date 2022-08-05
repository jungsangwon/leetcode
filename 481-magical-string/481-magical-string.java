class Solution {
    public int magicalString(int n) {
        int result = 1;
        int now = 1;
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 1; i<n; i++){
            int next = now==1?2:1;
            qu.add(next);
            int tmp = qu.poll();
            if(tmp==1){
                result++;
            }
            if(tmp==2){
                qu.add(next);
            }
            now = next;
        }
        return result;
    }
}