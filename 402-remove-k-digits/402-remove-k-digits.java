class Solution {
    public String removeKdigits(String num, int k) {
        int idx = 0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i)=='0'){
                idx++;
            }else{
                break;
            }
        }
        num = num.substring(idx);
        if(num.length()==0 || num.length()<=k){
            return "0";
        }else if(k==0){
            return num;
        }else{
            idx = -1;
            int before = 0;
            for(int i=before+1; i<num.length(); i++){
                if(num.charAt(before)>num.charAt(i)){
                    idx = before;
                    break;
                }else{
                    before = i;
                }
            }
            if(idx!=-1){
                return removeKdigits(num.substring(0,idx)+num.substring(idx+1),k-1);
            }else{
                return num.substring(0,num.length()-k);
            }
        }
    }
}