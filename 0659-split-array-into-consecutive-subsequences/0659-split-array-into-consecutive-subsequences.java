class Solution {
    public boolean isPossible(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            boolean check = false;
            for(int j = list.size()-1; j>=0; j--){
                List<Integer> t = list.get(j);
                if(t.get(t.size()-1)+1<nums[i]&&t.size()<3){
                    return false;
                }
                if(t.get(t.size()-1)+1==nums[i]){
                    t.add(nums[i]);
                    check = true;
                    break;
                }
            }
            if(!check){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        if(list.size()==1&&list.get(0).size()>5){
            return true;
        }else{
            for(List<Integer> t : list){
                if(t.size()<3){
                    return false;
                }
            }
            return true;
        }
    }
}