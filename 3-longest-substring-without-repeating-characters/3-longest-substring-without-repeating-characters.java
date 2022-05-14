import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int index = 0;
        int max = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> qu = new LinkedList<>();
        if(s.length()<=1){
            return s.length();
        }
        while(true){
            char now = s.charAt(index);
            if(map.containsKey(now)){
                if(max<len){
                    max = len;
                }
                while(true){
                    char tmp = qu.poll();
                    len--;
                    map.remove(tmp);
                    if(tmp==now){
                        break;
                    }
                }
                if(s.length()-index+len <= max){
                    break;
                }
            }
            qu.add(now);
            map.put(now,index);
            index++;
            len++;
            if(index >= s.length()){
                break;
            }
        }
        if(max<len){
            max = len;
        }
        return max;
    }
}