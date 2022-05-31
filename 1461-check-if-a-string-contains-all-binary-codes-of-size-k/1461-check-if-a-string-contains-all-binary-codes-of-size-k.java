class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        int len=(int)Math.pow(2,k);
        for(int i=0;i<s.length()-k+1;i++){
            set.add(s.substring(i,i+k));
        }
        
        if(set.size()==len){
            return true;
        }
        else{
            return false;
        }
    }
    
}