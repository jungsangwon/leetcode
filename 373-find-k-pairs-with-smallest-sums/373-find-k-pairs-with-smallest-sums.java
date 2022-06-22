class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] idx = new int[nums1.length];
        int len = nums2.length;
        
        int limit = Math.min(k,nums1.length*nums2.length);
        int max = 0;
        if(limit<=0){
            limit = k;
        }
        for(int i=0; i<limit; i++){
            int idx1=-1;
            int idx2=-1;
            int min = Integer.MAX_VALUE;
            for(int key=0; key<nums1.length; key++){
                if(key>max){
                    break;
                }
                if(idx[key]>=len){
                    continue;
                }
                int tidx = idx[key];
                int tmp = nums1[key] + nums2[tidx];
                if(tmp<min){
                    min = tmp;
                    idx1 = key;
                    idx2 = tidx;
                }else{
                    if(idx2<tidx){
                        break;
                    }
                }
            }
            max = Math.max(max,idx1+1);
            result.add(getList(nums1[idx1],nums2[idx2]));
            idx[idx1]++;
        }
        return result;
    }
    
    public List<Integer> getList(int a, int b){
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        return list;
    }
}