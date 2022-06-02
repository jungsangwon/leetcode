class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        List<Integer> unique = new ArrayList<>(count.keySet());
        int[] result = new int[k];
        if(k<unique.size()){
            Collections.sort(unique,new Comparator<>(){
               @Override
                public int compare(Integer a, Integer b){
                    return count.get(b) - count.get(a);
                }
            });
        }
        for(int i=0; i<k; i++){
            result[i] = unique.get(i);
        }
        return result;
    }
}