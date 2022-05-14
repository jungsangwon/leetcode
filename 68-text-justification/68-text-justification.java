class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = -1;
        int count  = 0;
        String[] str = new String[maxWidth+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=maxWidth; i++){
            sb.append(" ");
            str[i] = sb.toString();
        }
        for(int i=0; i<words.length; i++){
            len += words[i].length()+1;
            if(len<=maxWidth){
                count++;
            }else{
                result.add(getSentence(words,maxWidth,count,len-words[i].length()-1,i-count,str));
                count=0;
                len=-1;
                i--;
            }
        }
        if(count != 0){
            result.add(getLastSentence(words,maxWidth,count,len,words.length-count,str));
        }
        
        return result;
    }
    
    public String getLastSentence(String[] words, int maxWidth, int count, int len, int idx, String[] str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count-1; i++){
            sb.append(words[idx++]);
            sb.append(" ");
        }
        sb.append(words[idx]);
        int space = maxWidth - sb.length();
        if(space>0){
            sb.append(str[space]);
        }
        return sb.toString();
    }
    
    public String getSentence(String[] words, int maxWidth, int count, int len, int idx, String[] str){
        StringBuilder sb = new StringBuilder();
        if(count == 1){
            sb.append(words[idx]);
            while(sb.length()!=maxWidth){
                sb.append(" ");
            }
            return sb.toString();
        }
        int space = (maxWidth - len+ count - 1) / (count -1);
        int otherSpace = (maxWidth - len+ count - 1) % (count-1);
        
        for(int i = 0; i<count-1; i++){
            sb.append(words[idx++]);
            if(otherSpace > 0){
                sb.append(str[space+1]);
                otherSpace--;
            }else{
                sb.append(str[space]);
            }
        }
        sb.append(words[idx++]);
        return sb.toString();
    }
}