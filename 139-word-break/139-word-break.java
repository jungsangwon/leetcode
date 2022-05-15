class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        int[] check = new int[s.length()];
        int longest = 0;
        for(String str : wordDict){
            longest = Math.max(str.length(),longest);
        }
        int max = 0;
        for(String str : wordDict){
            HashSet<String> tmpSet = new HashSet<>(wordDict);
            int[] tmp = new int[str.length()];
            tmpSet.remove(str);
            if(!wordBreak(str, 0, tmpSet,longest,tmp)){
                wordSet.add(str);
                max = Math.max(max,str.length());
            }
        }
        return wordBreak(s,0,wordSet, max, check);
    }
    public boolean wordBreak(String s, int idx, HashSet<String> wordDict, int max, int[] check){
        boolean result = false;
        if(s.length()<=idx){
            return true;
        }
        if(check[idx]==1){
            return true;
        }else if(check[idx]==-1){
            return false;
        }
        StringBuilder st = new StringBuilder();
        for(int i=idx; i<s.length(); i++){
            st.append(s.charAt(i));
            if(st.length()>max){
                check[idx] = -1;
                return false;
            }
            if(wordDict.contains(st.toString())){
                result = result || wordBreak(s,i+1,wordDict,max,check);
            }
            if(result){
                check[idx] = 1;
                break;
            }
        }
        return result;
    }
}