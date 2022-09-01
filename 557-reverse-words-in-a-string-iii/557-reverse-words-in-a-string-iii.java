class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String t : str){
            result.append(new StringBuilder(t).reverse().toString());
            result.append(" ");
        }
        return result.substring(0,result.length()-1).toString();
    }
}