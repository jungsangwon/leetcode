class Solution {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String[] digits = {"","Thousand","Million","Billion"};
        String[] number = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] number2 = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] number3 = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(num!=0){
            if(num%1000!=0 && i!=0){
                if(result.length()!=0){
                    result.insert(0," ");
                }
                result.insert(0,digits[i]);
                result.insert(0," ");
            }
            result.insert(0,numberToWords((num%1000),number,number2,number3));
            i++;
            num=num/1000;
        }
        
        return result.toString();
    }
    
    public String numberToWords(int num, String[] number, String[] number2, String[] number3){
        StringBuilder sb = new StringBuilder();
        int a = num/100;
        num = num%100;
        int b = num/10;
        num = num%10;
        if(a!=0){
            sb.append(number[a]);
            sb.append(" Hundred");
        }
        if(b!=0){
            if(sb.length()!=0){
                sb.append(" ");
            }
            if(b==1){
                sb.append(number2[num]);
                return sb.toString();
            }else{
                sb.append(number3[b]);
            }
        }
        if(num!=0){
            if(sb.length()!=0){
                sb.append(" ");
            }
            sb.append(number[num]);
        }
        return sb.toString();
    }
}