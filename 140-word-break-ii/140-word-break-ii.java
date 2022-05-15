class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        boolean[] dp = new boolean[s.length()];
        
        for(int i=0; i<s.length(); i++){
            for(int j=i; j>=0; j--){
                String tmp = s.substring(j,i+1);
                if(wordDict.contains(tmp)){
                    if(j==0){
                        List<String> list = map.getOrDefault(i,new ArrayList<>());
                        list.add(tmp);
                        map.put(i,list);
                        dp[i] = true;
                    }else{
                        dp[i] = dp[i] || dp[j-1];
                        if(dp[j-1]){
                            List<String> list = map.getOrDefault(i,new ArrayList<>());
                            for(String str : map.get(j-1)){
                                list.add(str+" "+tmp);
                            }
                            map.put(i,list);
                        }
                    }
                }
            }
        }
        
        return map.getOrDefault(s.length()-1,new ArrayList<>());
    }
}