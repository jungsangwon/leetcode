class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 1;
        for(int i=1; i<=n; i++){
            int count = 1;
            for(int j=0; j<i; j++){
                count *= (9-j);
            }
            result += count;
            int withZero = 1;
            for(int j=0; j<i-1; j++){
                withZero *= (9-j);
            }
            withZero = withZero*(i-1);
            result += withZero;
            // System.out.println(i+" position -> "+count+" + "+withZero+" = "+result);
        }
        return result;
    }
}