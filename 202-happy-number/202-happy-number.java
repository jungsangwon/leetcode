class Solution {
    HashSet<Integer> hashSet = new HashSet<>();
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }else{
            if(hashSet.contains(n)){
                return false;
            }else{
                hashSet.add(n);
                int next = 0;
                while(n!=0){
                    int tmp = n%10;
                    next += (tmp*tmp);
                    n = n/10;
                }
                return isHappy(next);
            }
        }
    }
}