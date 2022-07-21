class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer,Integer> sum1 = getSum(nums1,nums2);
        HashMap<Integer,Integer> sum2 = getSum(nums3,nums4);
        for(int key : sum1.keySet()){
            int zero = -key;
            if(sum2.containsKey(zero)){
                result += sum1.get(key)*sum2.get(zero);
            }
        }
        return result;
    }
    public HashMap<Integer,Integer> getSum(int[] num1, int[] num2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<num1.length; i++){
            for(int j=0; j<num2.length; j++){
                int sum = num1[i] + num2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        return map;
    }
}