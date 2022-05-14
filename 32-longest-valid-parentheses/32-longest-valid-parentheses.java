class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        int result = 0;
        int count = 0;
        int len = 0;
        int total = 0;
        for(int i=0; i<length; i++){
            char tmp = s.charAt(i);
            if(tmp == '('){
                count++;
            }else{
                count--;
            }
            len++;
            if(count<0){
                if(result<total){
                    result = total;
                }
                len=0;
                count=0;
                total=0;
            }else if(count==0){
                total += len;
                len = 0;
            }
        }
        if(result<total){
            result = total;
        }
        
        count = 0;
        len = 0;
        total = 0;
        
        for(int i=length-1; i>=0; i--){
            char tmp = s.charAt(i);
            if(tmp == ')'){
                count++;
            }else{
                count--;
            }
            len++;
            if(count<0){
                if(result<total){
                    result = total;
                }
                len=0;
                count=0;
                total=0;
            }else if(count==0){
                total += len;
                len = 0;
            }
        }
        if(result<total){
            result = total;
        }
        
        return result;
    }
}