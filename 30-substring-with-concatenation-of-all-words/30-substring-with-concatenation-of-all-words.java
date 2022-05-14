class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int len = words[0].length();
        int full = len * words.length;
        for(int i=0; i<words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        
        for(int i=0; i<s.length(); i++){
            if(s.length()-i<full){
                break;
            }
            String str = check(s,i,len,map,"",full);
            if(str.length()==full){
                if(checkFull(str,map,len,words.length)){
                    result.add(i);
                }
            }
        }
        
        
        return result;
    }
    
    public boolean checkFull(String str, HashMap<String,Integer> map, int len, int count){
        int start = 0;
        HashMap<String,Integer> checkMap = new HashMap<>();
        boolean result = true;
        for(int i=0; i<count; i++){
            String tmp = str.substring(start,start+len);
            checkMap.put(tmp,checkMap.getOrDefault(tmp,0)+1);
            start = start+len;
        }
        for(String key : map.keySet()){
            if(!checkMap.containsKey(key) || (checkMap.get(key).intValue() != map.get(key).intValue())){
                return false;
            }
        }
        return result;
    }
    
    public String check(String s, int idx, int len, HashMap<String,Integer> map, String now, int full){
        if(now.length()==full){
            return now;
        }
        if(idx+len>s.length()){
            return now;
        }
        String check = s.substring(idx,idx+len);
        if(map.containsKey(check)){
            return check(s,idx+len, len, map, now+check, full);
        }else{
            return now;
        }
    }
}