class Solution {
    public int longestSubstring(String s, int k) {
        List<Sequence> list = new ArrayList<>();
        int result = 0;
        int count[] = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            Sequence sq = new Sequence(count);
            list.add(sq);
        }
        int limit = k;
        for(int i=list.size()-1; i>=limit-1; i--){
            if(list.get(i).isSubstring(k)){
                result = Math.max(result,i+1);
                limit = Math.max(limit,result);
            }else{
                for(int j=i-limit;j>=0;j--){
                    if(list.get(i).isSubstring(list.get(j),k)){
                        result = Math.max(result,i-j);
                        limit = Math.max(limit,result);
                    }
                }
            }
        }
        return result;
    }
}

class Sequence{
    int[] count;
    public Sequence(){
        count = new int[26];
    }
    public Sequence(int[] count){
        this.count = count.clone();
    }
    
    public int getValue(int idx){
        return count[idx];
    }
    
    public boolean isSubstring(int k){
        for(int i = 0; i<26;i++){
            if(count[i]!=0 && count[i]<k){
                return false;
            }
        }
        return true;
    }
    
    public boolean isSubstring(Sequence s, int k){
        for(int i = 0; i<26;i++){
            int tmp = count[i] - s.getValue(i);
            if(tmp!=0 && tmp<k){
                return false;
            }
        }
        return true;
    }
}