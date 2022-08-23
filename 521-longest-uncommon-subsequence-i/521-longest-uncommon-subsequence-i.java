class Solution {
    public int findLUSlength(String a, String b) {
        int result = -1;
        if(!isSubsequence(a.toCharArray(),b.toCharArray())){
            result = findLUSlength(a,b,new HashMap<>());
        }
        if(!isSubsequence(b.toCharArray(),a.toCharArray())){
            result = Math.max(result,findLUSlength(b,a,new HashMap<>()));
        }
        return result;
    }
    
    public int findLUSlength(String a, String b, HashMap<String,Integer> dp){
        if(a.length()==0){
            return -1;
        }
        if(dp.containsKey(a)){
            return dp.get(a);
        }
        if(!isSubsequence(a.toCharArray(),b.toCharArray())){
            dp.put(a,a.length());
            return a.length();
        }else{
            int result = -1;
            for(int i=0; i<a.length();i++){
                result = Math.max(result,findLUSlength(a.substring(0,i)+a.substring(i+1),b,dp));
            }
            dp.put(a,result);
            return result;
        }
    }
    
    public boolean isSubsequence(char[] a, char[] b){
        int idx = 0;
        if(a.length>b.length){
            return false;
        }
        for(int i=0; i<b.length; i++){
            if(idx==a.length){
                return true;
            }
            if(a[idx]==b[i]){
                idx++;
            }
        }
        return idx==a.length;
    }
}