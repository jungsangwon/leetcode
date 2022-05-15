class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int before=0;
        int count = 0;
        if(!pq.isEmpty()){
            count = 1;
            before = pq.poll();
        }
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            if(before == tmp){
                continue;
            }else if(before+1 == tmp){
                before++;
                count++;
            }else{
                if(max<count){
                    max = count;
                }
                before = tmp;
                count =1;
            }
        }
        if(max<count){
            max = count;
        }
        return max;
    }
}