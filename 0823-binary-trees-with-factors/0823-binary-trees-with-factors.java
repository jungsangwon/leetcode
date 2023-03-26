class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long result = 0;
        HashMap<Integer,Long> map = new HashMap<>();
        Arrays.sort(arr);
        for(int num : arr){
            long count = 0;
            for(int key : map.keySet()){
                if(num%key == 0){
                    int tmp = num/key;
                    if(map.containsKey(tmp)){
                        count += map.get(key)*map.get(tmp);
                        count %= 1000000007;
                    }
                }
            }
            count++;
            count %= 1000000007;
            map.put(num,count);
            result += count;
            result %= 1000000007;
        }
        return (int)result;
    }
}