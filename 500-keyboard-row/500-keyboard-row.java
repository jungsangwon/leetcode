class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        int[] c = getRow();
        for(int i=0; i<words.length;i++){
            if(isOneRow(words[i].toLowerCase(),c)){
                list.add(words[i]);
            }
        }
        String[] result = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public boolean isOneRow(String word, int[] c){
        int check = c[word.charAt(0)-'a'];
        for(int j=1; j<word.length(); j++){
            if(check!=c[word.charAt(j)-'a']){
                return false;
            }
        }
        return true;
    }
    
    public int[] getRow(){
        String[] str = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        int[] c = new int[26];
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str[i].length(); j++){
                c[str[i].charAt(j)-'a'] = i;
            }
        }
        return c;
    }
}