class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int up = 1;
        for(int i=digits.length-1; i>=0; i--){
            int tmp = up + digits[i];
            if(tmp >= 10){
                list.add(tmp % 10);
                up = 1;
            }else{
                up = 0;
                list.add(tmp);
            }
        }
        if(up == 1){
            list.add(1);
        }
        int[] result = new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            result[i] = list.get(list.size()-1-i);
        }
        return result;
    }
}