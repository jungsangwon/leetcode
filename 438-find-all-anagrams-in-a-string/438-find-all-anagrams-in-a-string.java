class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] tmp = new int[26];
        int[] now = new int[26];
        int start = 0;
        int last = 0;
        for(int i=0; i<p.length(); i++){
            tmp[p.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            now[idx]++;
            if(now[idx] == tmp[idx]){
                boolean check = true;
                for(int j=0; j<26; j++){
                    if(now[j] != tmp[j]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    result.add(start);
                }
            }else if(now[idx]>tmp[idx]){
                while(now[idx]!=tmp[idx]){
                    now[s.charAt(start++)-'a']--;
                }
                boolean check = true;
                for(int j=0; j<26; j++){
                    if(now[j] != tmp[j]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    result.add(start);
                }
            }
        }
        
        
        return result;
    }
}