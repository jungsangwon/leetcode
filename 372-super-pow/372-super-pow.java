class Solution {
    public int superPow(int a, int[] b) {
        if(a%1337==0){
            return 0;
        }else if(a==1){
            return a;
        }
        //pi(1337) = pi(7) * pi(191) = 6 * 190 = 1440
        int pi = 1;
        List<Integer> list = new ArrayList<>();
        getPi(1337,list);
        for(int i : list){
            pi *= (i-1);
        }
        int pow = 0;
        for(int i : b){
            pow = pow*10 +i;
            pow = pow % pi;
        }
        if(pow == 0){
            pow += pi;
        }
        return power(a,pow,1337);
    }
    
    public void getPi(int a, List<Integer> list){
        boolean check = true;
        for(int i = 2; i<a; i++){
            if(a%i==0){
                list.add(i);
                getPi(a/i,list);
                check = false;
                break;
            }
        }
        if(check){
            list.add(a);
        }
    }
    
    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }
}