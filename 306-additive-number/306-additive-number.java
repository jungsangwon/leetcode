class Solution {
    public boolean isAdditiveNumber(String num) {
        boolean result = false;
        int max = (num.length()-1)/2;
        for(int i=1; i<=max; i++){
            for(int j=i;j<num.length();j++){
                if(Math.max(i,j-i+1)+j>num.length()){
                    break;
                }
                if(!result){
                    result = isAdditiveNumber(num,0,i,j);
                }else{
                    return result;
                }
                
            }
        }
        return result;
    }
    
    public boolean isAdditiveNumber(String num, int start, int start2, int end) {
        String first = num.substring(start,start2);
        String second = num.substring(start2,end+1);
        long num1 = Long.parseLong(first);
        long num2 = Long.parseLong(second);
        if(first.length()!=String.valueOf(num1).length() || second.length()!=String.valueOf(num2).length()){
            return false;
        }
        String result = String.valueOf(num1+num2);
        int rest = num.length()-(end+1);
        // System.out.println("start : "+start+", start2 = "+start2+", end : "+end);
        // System.out.println(num1+" + "+num2+" = "+result);
        if(rest == result.length()){
            String next = num.substring(end+1);
            // System.out.println("next~ = "+next+", result = "+result+" -> "+result.equals(next));
            if(result.equals(next)){
                return true;
            }else{
                return false;
            }
        }else if(rest>result.length()){
            String next = num.substring(end+1,end+1+result.length());
            // System.out.println("next = "+next+", result = "+result+" -> "+result.equals(next));
            if(result.equals(next)){
                return isAdditiveNumber(num,start2,end+1,end+result.length());
            }else{
                return false;
            } 
        }else{
            return false;
        }
    }
    
}