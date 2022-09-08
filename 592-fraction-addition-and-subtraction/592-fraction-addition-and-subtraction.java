import java.util.StringTokenizer;
class Solution {
    public String fractionAddition(String expression) {
        String result = "0/1";
        if(expression.charAt(0)!='-'){
            expression = "+"+expression;
        }
        int idx = 0;
        StringTokenizer stk = new StringTokenizer(expression,"[+-]",true);
        while(stk.hasMoreTokens()){
            String next = stk.nextToken()+stk.nextToken();
            result = add(result,next);
        }
        if(result.charAt(0)=='+'){
            result = result.substring(1);
        }
        return result;
    }
    
    public String add(String result, String next){
        String[] r = result.split("/");
        String[] n = next.split("/");
        int[] n1 = new int[2];
        int[] n2 = new int[2];
        for(int i=0; i<2; i++){
            n1[i] = Integer.parseInt(r[i]);
            n2[i] = Integer.parseInt(n[i]);
        }
        if(n1[1]!=n2[1]){
            int div = n1[1]*n2[1]/gcd(Math.max(n2[1],n1[1]),Math.min(n2[1],n1[1]));
            n1[0] = n1[0] * (div/n1[1]);
            n2[0] = n2[0] * (div/n2[1]);
            n1[1] = div;
            n2[1] = div;
        }
        int sum = n1[0]+n2[0];
        boolean minus = false;
        if(sum==0){
            return "+0/1";
        }else if(sum<0){
            minus = true;
            sum*=-1;
        }
        int div = gcd(Math.max(sum,n1[1]),Math.min(sum,n1[1]));
        if(!minus){
            return "+"+sum/div +"/"+n1[1]/div;
        }else{
            return "-"+sum/div +"/"+n1[1]/div;
        }
    }
    
    public int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }else{
            return gcd(num2, num1 % num2);
        }
    }
}