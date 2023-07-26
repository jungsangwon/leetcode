class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Num> list = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            list.add(new Num(nums2[i],i));
        }
        
        Collections.sort(list,(a,b)->a.num==b.num?a.idx-b.idx:b.num-a.num);
        
        Arrays.sort(nums1);
        int[] result = new int[nums1.length];
        List<Num> tmp = new ArrayList<>();
        int idx = nums1.length-1;
        for(int i=0; i<list.size(); i++){
            Num t = list.get(i);
            if(t.num>=nums1[idx]){
                tmp.add(t);
                continue;
            }
            result[t.idx] = nums1[idx--];
        }
        for(Num t : tmp){
            result[t.idx] = nums1[idx--];
        }
        
        return result;
    }
}

class Num{
    int num;
    int idx;
    public Num(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}