class Solution {
    public int numFriendRequests(int[] ages) {
        int result = 0;
        Arrays.sort(ages);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=ages.length-1; i>=0; i--){
            if(map.containsKey(ages[i])){
                result += map.get(ages[i]);
                continue;
            }
            int cnt = 0;
            for(int j=i-1; j>=0; j--){
                double tmp1 = ages[i];
                double tmp2 = ages[j];
                if(tmp2>(tmp1*0.5)+7){
                    cnt++;
                }else{
                    break;
                }
            }
            // System.out.println(ages[i]+" : "+cnt);
            map.put(ages[i],cnt);
            result += cnt;
        }
        return result;
    }
}