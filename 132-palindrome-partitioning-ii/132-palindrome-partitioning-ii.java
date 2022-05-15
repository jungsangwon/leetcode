class Solution {
    public int minCut(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i)!=s.charAt(j)||(j-i>=2 && !dp[i+1][j-1])){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = true;
                    if(map.containsKey(i)){
                        map.get(i).add(j);
                    }else{
                        Queue<Integer> tmp = new LinkedList<>();
                        tmp.add(j);
                        map.put(i,tmp);
                    }
                }
            }
        }
        int last = s.length()-1;
        HashMap<Integer,Integer> tmap = new HashMap<>();
        Queue<Integer> next = new LinkedList<>();
        next.add(0);
        while(true){
            while(!next.isEmpty()){
                int tmp = next.poll();
                if(dp[tmp][last]){
                    return result;
                }
                Queue<Integer> now = map.get(tmp);
                while(!now.isEmpty()){
                    int num = now.poll();
                    tmap.put(num+1,1);
                }
            }
            result++;
            for(int i : tmap.keySet()){
                next.add(i);
            }
        }
    }
}