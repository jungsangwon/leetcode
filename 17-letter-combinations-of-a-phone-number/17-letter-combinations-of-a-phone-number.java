import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        Queue<String> qu = new LinkedList<>();
        String[] num = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0){
            return (List)qu;
        }
        qu.add("");
        for(int i=0; i<digits.length(); i++){
            int size = qu.size();
            for(int j=0; j<size; j++){
                String beforeCase = qu.poll();
                String tmp = num[Character.getNumericValue(digits.charAt(i))];
                for(int k=0; k<tmp.length(); k++){
                    qu.add(beforeCase+tmp.charAt(k));
                }
            }
        }
        return (List)qu;
    }
}