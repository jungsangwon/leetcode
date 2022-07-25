class Solution {
    public int findComplement(int num) {
        int result = 0;
        String tmp = Integer.toBinaryString(num);
        for(int i=0; i<tmp.length();i++){
            result *= 2;
            if(tmp.charAt(i)=='0'){
                result += 1;
            }
        }
        return result;
    }
}