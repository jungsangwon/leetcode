class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int[] count = new int[2];
        char before = s.charAt(0);
        count[s.charAt(0)-'0']=1;
        
        for(int i=1; i<s.length(); i++){
            if(before==s.charAt(i)){
                count[s.charAt(i)-'0']++;
                if(s.charAt(i)=='0'){
                    if(count[0]>count[1]){
                        continue;
                    }
                }else{
                    if(count[1]>count[0]){
                        continue;
                    }
                }
            }else{
                count[s.charAt(i)-'0']=1;
                before = s.charAt(i);
            }
            result++;
        }
        return result;
    }
}