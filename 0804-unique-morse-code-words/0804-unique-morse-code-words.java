class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word : words){
            int len = word.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len; i++){
                sb.append(codes[word.charAt(i)-'a']);
            }
            hashSet.add(sb.toString());
        }
        
        return hashSet.size();
    }
}