class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            hashSet.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if(hashSet.contains(nums2[i])){
                list.add(nums2[i]);
                hashSet.remove(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}