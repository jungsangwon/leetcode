class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        boolean minus = false;
        
        if(s.length() == 0){
            return 0;
        }
        
        if(s.charAt(0)=='-'){
            s=s.substring(1,s.length());
            minus = true;
        }else if(s.charAt(0)=='+'){
            s=s.substring(1,s.length());
        }

        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp>'9'||tmp<'0'){
                s=s.substring(0,i);
                break;
            }
        }
        
        int index = 0;
        for(int i = 0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '0'){
                index++;
            }else{
                break;
            }
        }
        s=s.substring(index,s.length());
        
        if(s.length()>10){
            if(minus){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        
        long tmp;
        try{
            tmp = Long.parseLong(s);
        }catch(Exception e){
            return 0;
        }
        
        if(minus){
            tmp *= -1;
        }
        
        if(tmp > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(tmp < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        
        return (int)tmp;
    }
}