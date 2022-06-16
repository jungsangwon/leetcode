class Solution {
    public int getSum(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int bit = 0;
        char[] binaryA = Integer.toBinaryString(a).toCharArray();
        char[] binaryB = Integer.toBinaryString(b).toCharArray();
        if(binaryA.length<binaryB.length){
            char[] tmp = binaryA;
            binaryA = binaryB;
            binaryB = tmp;
        }
        int idxA = binaryA.length-1;
        int idxB = binaryB.length-1;
        for(int i=0; i<binaryB.length; i++){
            int ca = Character.getNumericValue(binaryA[idxA--]);
            int cb = Character.getNumericValue(binaryB[idxB--]);
            sb.append((ca^cb)^bit);
            int[] check = new int[3];
            check[0] = bit&ca;
            check[1] = bit&cb;
            check[2] = ca&cb;
            if((check[0]==1)||(check[1]==1)||(check[2]==1)){
                bit = 1;
            }else{
                bit = 0;
            }
        }
        for(int i=idxA; i>=0; i--){
            int ca = Character.getNumericValue(binaryA[i]);
            sb.append(ca^bit);
            int check = bit&ca;
            if(check==1){
                bit = 1;
            }else{
                bit = 0;
            }
        }
        if(bit==1){
            sb.append("1");
        }
        int result = 0;
        int now = 1;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='1'){
                result += now;
            }
            now = now<<1;
        }
        return result;
    }
}
