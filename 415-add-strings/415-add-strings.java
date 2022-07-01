class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int up = 0;
        int len = Math.min(num1.length(),num2.length());
        int idx1 = num1.length()-1;
        int idx2 = num2.length()-1;
        for(int i=0; i<len; i++){
            int a = num1.charAt(idx1)-'0';
            int b = num2.charAt(idx2)-'0';
            int sum = a+b+up;
            if(sum>9){
                up=1;
                sum -= 10;
            }else{
                up=0;
            }
            result = sum + result;
            idx1--;
            idx2--;
        }
        
        for(int i=idx1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            int sum = a+up;
            if(sum>9){
                up=1;
                sum -= 10;
            }else{
                up=0;
            }
            result = sum + result;
        }
        
        for(int i=idx2;i>=0;i--){
            int a = num2.charAt(i)-'0';
            int sum = a+up;
            if(sum>9){
                up=1;
                sum -= 10;
            }else{
                up=0;
            }
            result = sum + result;
        }
        if(up!=0){
            result = up + result;
        }
        return result;
    }
}