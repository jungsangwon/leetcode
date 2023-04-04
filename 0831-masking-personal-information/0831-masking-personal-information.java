class Solution {
    public String maskPII(String s) {
        int idx1 = s.indexOf('@');
        if(idx1!=-1){
            String tmp = s.substring(0,idx1);
            s = tmp.charAt(0)+"*****"+tmp.charAt(tmp.length()-1)+s.substring(idx1);
            s = s.toLowerCase();
        }else{
            s = s.replaceAll("[+ \\- \\( \\) ]","");
            if(s.length()==10){
                s="***-***-"+s.substring(6,10);
            }else if(s.length()==11){
                s="+*-***-***-"+s.substring(7,11);
            }else if(s.length()==12){
                s="+**-***-***-"+s.substring(8,12);
            }else{
                s="+***-***-***-"+s.substring(9,13);
            }
        }
        
        return s;
    }
}