class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,List<Integer>> count = new HashMap<>();
        int max = 0;
        int result = nums.length;
        for(int i=0; i<nums.length; i++){
            List<Integer> list = count.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            count.put(nums[i],list);
        }
        for(int num : count.keySet()){
            List<Integer> list = count.get(num);
            if(list.size()>max){
                max = list.size();
                result = list.get(list.size()-1) -list.get(0) +1;
            }else if(list.size()==max){
                result = Math.min(result,list.get(list.size()-1) -list.get(0) +1);
            }
        }
        
        return result;
    }
}