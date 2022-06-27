class Solution {
    public int integerReplacement(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        return integerReplacement(n,map);
    }
    
    public int integerReplacement(int n,  HashMap<Integer,Integer> map) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        int count = 0;
        if(n%2==0){
            count += integerReplacement(n/2,map) + 1;
        }else{
            count = Math.min(integerReplacement((n/2)+1,map),integerReplacement((n/2),map)) + 2;
        }
        map.put(n,count);
        return count;
    }
}