class Solution {
    public String originalDigits(String s) {
        int[] result = new int[10];
        int[] count = new int[26];
        char[] list = s.toCharArray();
        for(char c : list){
            count[c-'a']++;
        }
        String[] tmp = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] go = {0,2,4,6,8,1,3,5,7,9};
        char[] key = {'z','o','w','r','u','f','x','v','g','i'};
        
        for(int i=0; i<10; i++){
            result[go[i]] = getCount(count,tmp[go[i]],key[go[i]]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            for(int j=0; j<result[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
    public int getCount(int[] count, String now, char c){
        int result = count[c-'a'];
        for(int i=0; i<now.length(); i++){
            count[now.charAt(i)-'a']-=result;
        }
        return result;
    }
}