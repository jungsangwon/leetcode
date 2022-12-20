class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] c = s.toCharArray();
        int[] count = new int[26];
        for(int i=0; i<c.length; i++){
            count[c[i]-'a']++;
        }
        int[] now = new int[26];
        int cnt = 0;
        for(int i=0; i<c.length; i++){
            int idx = c[i]-'a';
            cnt++;
            now[idx]++;
            if(now[idx]==count[idx]){
                boolean check = true;
                for(int j=0; j<26; j++){
                    if(now[j]!=0 && now[j]!=count[j]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    result.add(cnt);
                    cnt=0;
                }
            }
        }
        return result;
    }
}