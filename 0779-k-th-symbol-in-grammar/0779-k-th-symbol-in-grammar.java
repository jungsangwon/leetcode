class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }else{
            int before = kthGrammar(n-1,((k-1)/2)+1);
            if(before == 0){
                if((k-1)%2==0){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                if((k-1)%2==0){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
    }
}