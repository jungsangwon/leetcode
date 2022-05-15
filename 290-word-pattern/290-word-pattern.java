class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> check = new HashSet<>();
        if(str.length!=pattern.length()){
            return false;
        }
        for(int i=0; i<str.length; i++){
            char key =pattern.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(str[i])){
                    return false;
                }
            }else{
                if(check.contains(str[i])){
                    return false;
                }
                map.put(key,str[i]);
                check.add(str[i]);
            }
        }
        return true;
    }
}