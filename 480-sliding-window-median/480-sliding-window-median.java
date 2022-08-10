class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];
        Comparator<Integer> comparator = new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                if(nums[a]==nums[b]){
                    return a-b;
                }else{
                    return Integer.compare(nums[a],nums[b]);
                }
            }
        };
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        int idx = 1;
        for(int i=0; i<k; i++){
            left.add(i);
        }
        balance(left,right);
        result[0] = getResult(k,nums,left,right);
        for(int i=k;i<nums.length;i++){
            if(!left.remove(i-k)){
                right.remove(i-k);
            }
            right.add(i);
            left.add(right.pollFirst());
            balance(left,right);
            result[idx++]=getResult(k,nums,left,right);
        }
        return result;
    }
    
    public void balance(TreeSet<Integer> left, TreeSet<Integer> right){
        while(left.size()>right.size()){
            right.add(left.pollFirst());
        }
    }
    
    public double getResult(int k, int[] nums, TreeSet<Integer> left, TreeSet<Integer> right){
        if(k%2==0){
            double result = nums[left.first()];
            result+=nums[right.first()];
            return result/2;
        }else{
            return (double)nums[right.first()];
        }
    }

}