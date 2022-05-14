import java.math.*;
class Solution {
    public double myPow(double x, int n) {
        long ln = n;
        if(ln<0){
            ln *=-1;
        }
        double result = pow(x,ln);
              
        return n<0? 1/result : result;
    }
    public double pow(double x, long n){
        if(n == 0)
            return 1;

        return n%2 == 0 ? pow(x*x, n/2) : x*pow(x*x, (n-1)/2); 
    }
}