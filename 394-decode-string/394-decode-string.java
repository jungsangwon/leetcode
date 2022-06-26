class Solution {
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(;idx<s.length();idx++){
            char c = s.charAt(idx);
            if(c<='z'&&c>='a'){
                result.append(c);
            }else if(c==']'){
                return result.toString();
            }else if(c=='['){
                idx++;
                String now = decodeString(s);
                // System.out.println(count+"->"+now);
                for(; count>0; count--){
                    result.append(now);
                }
            }else{
                count = count*10 + (c-'0');
                // System.out.println(count);
            }
        }
        return result.toString();
    }
}