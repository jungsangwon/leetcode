class Solution {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean minus = false;
        if(num<0){
            minus = true;
            num+=1;
            num *= -1;
        }
        while(num>0){
            if(minus){
                result.append((num%2)^1);
            }else{
                result.append(num%2);
            }
            num=num/2;
        }
        if(minus){
            while(result.length()!=32){
                result.append("1");
            }
        }
        String res = "";
        for(int i=0; i<result.length();i+=4){
            res = toHex(result.substring(i,Math.min(i+4,result.length())))+res;
        }
        return res;
    }
    
    public char toHex(String num){
        char[] c = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int idx = 0;
        int now = 1;
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)=='1'){
                idx+=now;
            }
            now*=2;
        }
        return c[idx];
    }
}