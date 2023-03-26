class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String tmp = "a";
        for(int i=0; i<words.length; i++){
            char c = words[i].charAt(0);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                words[i] = words[i] + "ma"+tmp;
            }else{
                words[i] = words[i].substring(1)+ c + "ma"+tmp;
            }
            tmp+="a";
        }
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word);
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
}