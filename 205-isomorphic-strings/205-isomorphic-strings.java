class Solution {
    public boolean isIsomorphic(String s, String t) {
        boolean result = true;
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs)!=ct){
                    return false;
                }
            }else{
                if(hashSet.contains(ct)){
                    return false;
                }
                map.put(cs,ct);
                hashSet.add(ct);
            }
        }
        
        return result;
    }
}