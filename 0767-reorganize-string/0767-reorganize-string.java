class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        int sum = 0;
        int max = 0;
        for(int i=0; i<26; i++){
            sum += count[i];
            max = Math.max(count[i],max);
        }
        if(max-1>sum-max){
            return "";
        }else{
            Word[] list = new Word[26];
            for(int i=0; i<26; i++){
                Word w = new Word((char)('a'+i),count[i]);
                list[i] = w;
            }
            Arrays.sort(list,(Word a, Word b)->b.count-a.count);
            StringBuilder result = new StringBuilder();
            for(int i=0; i<list[0].count; i++){
                result.append(list[0].c);
            }
            int idx = result.length()-1;
            for(int i=1; i<26; i++){
                if(list[i].count==0){
                    break;
                }
                for(int j=0; j<list[i].count; j++){
                    result.insert(idx,list[i].c);
                    idx--;
                    if(idx<0){
                        idx = result.length()-1;
                    }
                }
            }
            return result.toString();
        }
    }
}

class Word{
    char c;
    int count;
    public Word(char c, int count){
        this.c = c;
        this.count = count;
    }
    
}