class Solution {
    public boolean reorderedPowerOf2(int n) {
        String now = String.valueOf(n);
        long tmp =1;
        while(true){
            String str = String.valueOf(tmp);
            if(str.length()>now.length()){
                break;
            }else if(str.length() == now.length()){
                if(canSwap(str,now)){
                    return true;
                }
            }
            tmp *= 2;
        }
        return false;
    }
    
    public boolean canSwap(String a, String b){
        int[] num = new int[10];
        for(int i=0; i<a.length(); i++){
            num[a.charAt(i)-'0']++;
        }
        for(int i=0; i<b.length(); i++){
            num[b.charAt(i)-'0']--;
        }
        for(int i=0; i<10; i++){
            if(num[i]!=0){
                return false;
            }
        }
        return true;
    }
}