class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int limit = len / 2;
        for(int i=1;i<=limit;i++){
            if(len%i==0){
                boolean check = true;
                String repeat = s.substring(0,i);
                int start = i;
                while(start<len){
                    String tmp = s.substring(start,start+i);
                    if(!tmp.equals(repeat)){
                        check = false;
                        break;
                    }else{
                        start+=i;
                    }
                }
                if(check){
                    return true;
                }
            }
        }
        return false;
    }
}