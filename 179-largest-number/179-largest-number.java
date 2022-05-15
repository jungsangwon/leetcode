class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder st = new StringBuilder();
        String[] numList = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            numList[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numList,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String str_a = a+b;
                String str_b = b+a;
                return str_b.compareTo(str_a);
            }
        });
        for(String str : numList){
            st.append(str);
        }
        for(int i=0; i<st.length()-1; i++){
            if(st.charAt(i)=='0'){
                continue;
            }else{
                return st.substring(i,st.length());
            }
        }
        return st.substring(st.length()-1,st.length());
    }
}