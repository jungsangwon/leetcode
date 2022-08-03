class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<String,Integer> dp = new HashMap<>();
        Binary[] binary = new Binary[strs.length];
        for(int i=0;i<strs.length;i++){
            int num0 = 0;
            int num1 = 0;
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j)=='0'){
                    num0++;
                }else{
                    num1++;
                }
            }
            binary[i] = new Binary(num1,num0);
        }
        Arrays.sort(binary,new Comparator<Binary>(){
           @Override
            public int compare(Binary a, Binary b){
                return a.zero==b.zero ? a.one-b.one : a.zero-b.zero;
            }
        });
        return findMaxForm(binary,m,n,0,dp);
    }
    
    public int findMaxForm(Binary[] strs, int m, int n, int idx, HashMap<String,Integer> dp){
        String key = idx+","+m+","+n;
        if(idx>=strs.length || m<strs[idx].zero){
            return 0;
        }
        if(dp.containsKey(key)){
            return dp.get(key);
        }else{
            int max = 0;
            if(strs[idx].zero<=m && strs[idx].one<=n){
                max = findMaxForm(strs,m-strs[idx].zero,n-strs[idx].one,idx+1,dp)+1;
            }
            max = Math.max(max,findMaxForm(strs,m,n,idx+1,dp));
            dp.put(key,max);
            return max;
        }
    }
}

class Binary{
    int one;
    int zero;
    
    public Binary(int one, int zero){
        this.one=one;
        this.zero=zero;
    }
}