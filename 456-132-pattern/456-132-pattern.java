class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            min[i] = Math.min(min[i-1],nums[i-1]);
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i=nums.length-2; i>0; i--){
            pq2.add(nums[i+1]);
            while(!pq2.isEmpty() && pq2.peek()<nums[i]){
                pq1.add(pq2.poll());
            }
            if(min[i]>=nums[i]){
                continue;
            }else{
                while(!pq1.isEmpty()){
                    if(pq1.peek()>=nums[i]){
                        pq2.add(pq1.poll());
                    }else if(pq1.peek()>min[i]){
                        return true;
                    }else{
                        break;
                    }
                }
            }
        }
        return false;
    }
}