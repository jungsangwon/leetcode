class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int now = 0;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            int t = widths[tmp-'a'];
            if(sum+t>100){
                now++;
                sum = t;
            }else{
                sum+=t;
            }
        }
        now++;
        result[0] = now;
        result[1] = sum;
        return result;
    }
}