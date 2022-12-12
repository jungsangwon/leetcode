class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for(int i=0; i<licensePlate.length(); i++){
            char tmp = licensePlate.charAt(i);
            if(tmp<='z' && tmp>='a'){
                count[tmp-'a']++;
            }
        }
        int len = Integer.MAX_VALUE;
        String result = "";
        for(int i=0; i<words.length; i++){
            if(len<=words[i].length()){
                continue;
            }
            int[] tmp = new int[26];
            for(int j=0; j<words[i].length(); j++){
                tmp[words[i].charAt(j)-'a']++;
            }
            boolean check = true;
            for(int j=0; j<26; j++){
                if(tmp[j]<count[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                result = words[i];
                len = words[i].length();
            }
        }
        return result;
    }
}