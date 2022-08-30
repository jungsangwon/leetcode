class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        int count = 0;
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++){
            if(c[i]=='A'){
                a++;
                count=0;
            }else if(c[i]=='L'){
                count++;
            }else{
                count=0;
            }
            l = Math.max(l,count);
        }
        return a<2 && l<3;
    }
}