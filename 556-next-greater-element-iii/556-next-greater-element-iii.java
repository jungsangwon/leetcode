class Solution {
    public int nextGreaterElement(int n) {
        int first = n;
        int result = 0;
        int[] c = new int[10];
        int before = -1;
        while(n>0){
            int now = n%10;
            if(before>now){
                break;
            }
            c[now]++;
            n /= 10;
            before = now;
        }
        if(n==0){
            return -1;
        }
        result = n/10;
        int last = n%10;
        c[last]++;
        for(int i=last+1; i<10; i++){
            if(c[i]!=0){
                c[i]--;
                result = result*10+i;
                break;
            }
        }
        for(int i=0; i<10; i++){
            for(int j=0; j<c[i]; j++){
                result = result*10+i;
                if(result<0){
                    return -1;
                }
            }
        }
        if(result <= first){
            return -1;
        }
        return result;
    }
}