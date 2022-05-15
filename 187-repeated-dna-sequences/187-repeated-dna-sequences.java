class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> hashSet = new HashSet<>();
        int len = s.length()-10;
        for(int i=0;i<=len; i++){
            String tmp = s.substring(i,i+10);
            if(hashSet.contains(tmp)){
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }else{
                hashSet.add(tmp);
            }
        }
        return new ArrayList<>(result);
    }
    
}