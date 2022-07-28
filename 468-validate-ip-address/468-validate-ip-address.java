class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.length()==0){
            return "Neither";
        }else if(isIPv4(queryIP)){
            return "IPv4";
        }else if(isIPv6(queryIP)){
            return "IPv6";
        }else{
            return "Neither";
        }
    }
    
    public boolean isIPv4(String queryIP){
        if(queryIP.charAt(0)=='.' || queryIP.charAt(queryIP.length()-1) =='.'){
            return false;
        }
        String[] ip = queryIP.split("\\.");
        if(ip.length!=4){
            return false;
        }
        try{
            for(int i=0; i<4; i++){
                int tmp = Integer.parseInt(ip[i]);
                if(tmp<0 || tmp>255 || !ip[i].equals(String.valueOf(tmp))){
                    return false;
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean isIPv6(String queryIP){
        if(queryIP.charAt(0)==':' || queryIP.charAt(queryIP.length()-1) ==':'){
            return false;
        }
        String[] ip = queryIP.split(":");
        if(ip.length!=8){
            return false;
        }
         for(int i=0; i<8; i++){
            if(ip[i].length()<1 || ip[i].length()>4 || !isHexadecimal(ip[i])){
                return false;
            }
        }
        return true;
    }
    
    public boolean isHexadecimal(String str){
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)>='0'&&str.charAt(i)<='9') || (str.charAt(i)>='A'&&str.charAt(i)<='F') || (str.charAt(i)>='a'&&str.charAt(i)<='f') ){
                
            }else{
                return false;
            }
        }
        return true;
    }
}
