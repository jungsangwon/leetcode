import java.util.*;
class Solution {
    public int romanToInt(String s) {
        int[] value = {1000,500,100,50,10,5,1};
        char[] symbol = {'M','D','C','L','X','V','I'};
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0; i<7; i++){
            map.put(symbol[i],value[i]);
        }
        for(int i=0; i<s.length(); i++){
            if(i+1<s.length()&&map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                result = result + map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }else{
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}