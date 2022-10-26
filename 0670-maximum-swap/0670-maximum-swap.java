class Solution {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int max = c[c.length-1]-'0';
        int left = -1;
        int right = -1;
        int idx = c.length-1;
        for(int i = c.length-2; i>=0; i--){
            if(max<c[i]-'0'){
                max = c[i]-'0';
                idx = i;
            }else if(max>c[i]-'0'){
                left = i;
                right = idx;
            }
        }
        if(left!=-1){
            int result = 0;
            char t = c[left];
            c[left] = c[right];
            c[right] = t;
            for(int i=0; i<c.length; i++){
                result = result*10 + c[i]-'0';
            }
            return result;
        }else{
            return num;
        }
    }
}