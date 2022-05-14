class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(result,n-1,0,1,0);
        return result;
    }
    
    public void dfs(List<Integer> result, int n, int first, int second, long now){
        long num1 = now*10+first;
        long num2 = now*10+second;
        if(n==0){
            int result1 = 0;
            int result2 = 0;
            int tmp = 1;
            while(num1!=0){
                result1 += (num1%10) * tmp;
                num1 = num1/10;
                tmp *= 2;
            }
            tmp = 1;
            while(num2!=0){
                result2 += (num2%10) * tmp;
                num2 = num2/10;
                tmp *= 2;
            }
            if(now%10 == 1){
                result.add(result2);
                result.add(result1);
            }else{
                result.add(result1);
                result.add(result2);
            }
        }else{
            if(now%10 == 1){
                dfs(result,n-1,second,first,num2);
                dfs(result,n-1,second,first,num1);
            }else{
                dfs(result,n-1,first,second,num1);
                dfs(result,n-1,first,second,num2);
            }
        }
    }
}