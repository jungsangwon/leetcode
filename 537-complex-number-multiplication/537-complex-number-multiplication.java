class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = getNum(num1);
        int[] n2 = getNum(num2);
        int real = n1[0]*n2[0] - (n1[1]*n2[1]);
        int imaginary = (n1[0] * n2[1]) + (n1[1] * n2[0]);
        return real+"+"+imaginary+"i";
    }
    
    public int[] getNum(String num1){
        String real = num1.substring(0,num1.indexOf("+"));
        String imaginary = num1.substring(num1.indexOf("+")+1,num1.length()-1);
        int[] result = new int[2];
        result[0] = Integer.parseInt(real);
        result[1] = Integer.parseInt(imaginary);
        
        return result;
    }
}