class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int up = 0;
        int idx1 = a.length()-1;
        int idx2 = b.length()-1;
        while(idx1>=0 || idx2 >=0){
            int a1 = 0;
            int a2 = 0;
            if(idx1>=0){
                a1 = a.charAt(idx1) - '0';
                idx1--;
            }
            if(idx2>=0){
                a2 = b.charAt(idx2) - '0';
                idx2--;
            }
            if(a1+a2+up>=2){
                result = ((a1+a2+up)%2) + result;
                up = 1;
            }else{
                result = ((a1+a2+up)%2) + result;
                up = 0;
            }
        }
        if(up==1){
            result = "1"+result;
        }
        
        return result;
    }
}