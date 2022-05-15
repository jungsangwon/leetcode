class Solution {
    public int numDistinct(String s, String t) {
        int[][] check = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                check[i][j] = -1;
            }
        }
        return numDistinct(s,t,0,0, check);
    }
    
    public int numDistinct(String s, String t, int idx1, int idx2, int[][] check){
        // System.out.println(idx1+" "+idx2);
        if(idx2>=t.length()){
            return 1;
        }else if(idx1>=s.length()){
            return 0;
        }else{
            if(check[idx1][idx2]!=-1){
                return check[idx1][idx2];
            }
            int result = 0;
            int max = s.length() - (t.length()-idx2) + 1;
            for(int i = idx1; i<max; i++){
                if(s.charAt(i)==t.charAt(idx2)){
                    result += numDistinct(s,t,i+1,idx2+1, check);
                }
            }
            check[idx1][idx2] = result;
            return result;
        }
    }
}