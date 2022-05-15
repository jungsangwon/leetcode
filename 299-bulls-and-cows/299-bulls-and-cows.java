class Solution {
    public String getHint(String secret, String guess) {
        String result = "";
        int[] check = new int[secret.length()];
        HashMap<Character,Integer> s_map = new HashMap<>();
        HashMap<Character,Integer> g_map = new HashMap<>();
        int count = 0;
        for(int i=0;i<check.length;i++){
            if(secret.charAt(i)==guess.charAt(i)){
                check[i]=1;
                count++;
            }else{
                s_map.put(secret.charAt(i),s_map.getOrDefault(secret.charAt(i),0)+1);
                g_map.put(guess.charAt(i),g_map.getOrDefault(guess.charAt(i),0)+1);
            }
        }
        result += count+"A";
        count = 0;
        for(char key : s_map.keySet()){
            if(g_map.containsKey(key)){
                count += Math.min(s_map.get(key),g_map.get(key));
            }
        }
        result += count+"B";
        return result;
    }
}