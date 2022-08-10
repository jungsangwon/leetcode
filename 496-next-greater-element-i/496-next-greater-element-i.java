class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    for(int k=j+1;k<nums2.length;k++){
                        if(nums2[j]<nums2[k]){
                            result[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}