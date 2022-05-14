class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        
        for(int i = 1; i<strs.length; i++){
            if(result.length()==0){
                break;
            }
            int min = Math.min(result.length(),strs[i].length());
            int index = 0;
            for(int j = 0; j<min; j++){
                if(result.charAt(j)!=strs[i].charAt(j)){
                    break;
                }else{
                    index++;
                }
            }
            result = result.substring(0,index);
        }
        
        return result;
    }
}