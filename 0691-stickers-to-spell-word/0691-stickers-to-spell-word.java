class Solution {
    public int minStickers(String[] stickers, String target) {
        int[][] count = new int[stickers.length][26];
        int[] check = new int[26];
        HashMap<String,Integer> map = new HashMap<>();
        map.put(getKey(check),0);
        for(int i=0; i<stickers.length; i++){
            char[] c = stickers[i].toCharArray();
            for(int j=0; j<c.length; j++){
                count[i][c[j]-'a']++;
            }
        }
        char[] c = target.toCharArray();
            for(int j=0; j<c.length; j++){
                check[c[j]-'a']++;
            }
        return minStickers(count,check,map);
    }
    
    public int minStickers(int[][] stickers, int[] target, HashMap<String,Integer> map) {
        String key = getKey(target);
        if(map.containsKey(key)){
            return map.get(key);
        }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(target[i]!=0){
                for(int j=0; j<stickers.length; j++){
                    if(stickers[j][i]>0){
                        int[] nextTarget = target.clone();
                        for(int k=i; k<26; k++){
                            nextTarget[k]-=Math.min(nextTarget[k],stickers[j][k]);
                        }
                        result = Math.min(result,minStickers(stickers,nextTarget,map));
                    }
                }
                break;
            }
        }
        
        if(result == Integer.MAX_VALUE || result==-1){
            result = -1;
        }else{
            result++;
        }
        map.put(key,result);
        return result;
    }
    
    public String getKey(int[] target){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            sb.append(target[i]);
            sb.append(",");
        }
        return sb.toString();
    }
}