import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        HashMap<Integer, Queue<Character>> map = new HashMap<>();
        int len = s.length();
        int rowNum = 1;
        int direction = 1;
        numRows = numRows > len ? len : numRows;
        
        if(numRows == 1){
            return s;
        }
        
        for(int i = 1; i<=numRows; i++){
            map.put(i,new LinkedList<>());
        }
        
        for(int i = 0; i < len; i++){
            map.get(rowNum).add(s.charAt(i));
            rowNum += direction;
            if(!map.containsKey(rowNum)){
                direction *= -1;
                rowNum += direction * 2;
            }
        }
        
        for(int i = 1; i<=numRows; i++){
            Queue<Character> qu = map.get(i);
            while(!qu.isEmpty()){
                result.append(qu.poll());
            }
        }
        return result.toString();
    }
}