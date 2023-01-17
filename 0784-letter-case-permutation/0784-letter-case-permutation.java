class Solution {
    int dif = 'a' - 'A';
    public List<String> letterCasePermutation(String s) {
        char[] c= s.toCharArray();
        List<String> result = new ArrayList<>();
        letterCasePermutation(c,0,result);
        return result;
        
    }
    public void letterCasePermutation(char[] c, int idx, List<String> result) {
        if(idx==c.length){
            result.add(String.valueOf(c));
        }else{
            if(c[idx]<='Z' && c[idx]>='A'){
                c[idx] = (char)(c[idx] + dif);
                letterCasePermutation(c,idx+1,result);
                c[idx] = (char)(c[idx] - dif);
            }else if(c[idx]<='z' && c[idx]>='a'){
                c[idx] = (char)(c[idx] - dif);
                letterCasePermutation(c,idx+1,result);
                c[idx] = (char)(c[idx] + dif);
            }
            letterCasePermutation(c,idx+1,result);
        }
    }
}