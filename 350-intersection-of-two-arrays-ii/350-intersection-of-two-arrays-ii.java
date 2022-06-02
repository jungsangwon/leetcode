class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0; i<nums2.length; i++){
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                int count = Math.min(map1.get(key),map2.get(key));
                for(int i=0; i<count; i++){
                    list.add(key);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}