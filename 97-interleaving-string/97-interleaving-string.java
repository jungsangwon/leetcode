class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String,Boolean> map = new HashMap<>();
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return isInterleave(s1,s2,s3,0,0,0,map);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int idx1, int idx2, int idx3, HashMap<String,Boolean> map){
        if(idx3 == s3.length()){
            return true;
        }
        String key = idx1+"_"+idx2+"_"+idx3;
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean result = false;
        if(s1.length()>idx1 && s1.charAt(idx1)==s3.charAt(idx3)){
            result = result || isInterleave(s1,s2,s3,idx1+1,idx2,idx3+1,map);
        }
        if(s2.length()>idx2 && s2.charAt(idx2)==s3.charAt(idx3)){
            result = result || isInterleave(s1,s2,s3,idx1,idx2+1,idx3+1,map);
        }
        map.put(key,result);
        return result;
    }
}