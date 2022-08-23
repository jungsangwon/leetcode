class Solution {
    public int findLUSlength(String[] strs) {
        HashMap<String,Boolean> dp = new HashMap<>();
        Arrays.sort(strs,(String a, String b)->b.length()-a.length());
        for(int i=0; i<strs.length; i++){
            int now = findLUSlength(strs[i],strs,i,dp);
            if(now!=-1){
                return now;
            }
        }
        return -1;
    }
    
    public int findLUSlength(String now, String[] strs, int idx, HashMap<String,Boolean> dp) {
        if(now.length()==0){
            return -1;
        }
        if(dp.containsKey(now)){
            return dp.get(now)?now.length():-1;
        }
        for(int i=0; i<strs.length; i++){
            if(i==idx){
                continue;
            }else{
                if(isSubsequence(now.toCharArray(),strs[i].toCharArray())){
                    dp.put(now,false);
                    return -1;
                }
            }
        }
        dp.put(now,true);
        return now.length();
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
