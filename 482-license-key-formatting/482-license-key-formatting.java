class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int count = 0;
        for(int i=c.length-1; i>=0; i--){
            if(c[i]!='-'){
                count++;
                sb.insert(0,Character.toUpperCase(c[i]));
            }
            if(count==k){
                sb.insert(0,"-");
                count=0;
            }
        }
        if(sb.length()==0){
            return sb.toString();
        }else if(sb.charAt(0)=='-'){
            return sb.substring(1).toString();
        }else{
            return sb.toString();
        }
    }
}