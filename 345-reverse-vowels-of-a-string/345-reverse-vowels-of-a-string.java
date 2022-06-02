class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] str = s.toCharArray();
        while(left<right){
            boolean l = isVowel(str[left]);
            boolean r = isVowel(str[right]);
            if(l && r){
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }
            if(!l){
                left++;                
            }
            if(!r){
                right--;
            }
        }
        return String.valueOf(str);
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c =='e' || c=='i' || c=='o' || c=='u' || c == 'A' || c =='E' || c=='I' || c=='O' || c=='U';
    }
}
