class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("(",1,0,n,result);
        return result;
    }
    public void generate(String now, int lcnt, int rcnt, int n, List<String> result){
        if(now.length() == n*2-1){
            result.add(now+")");
        }else{
            if(rcnt<n && lcnt>rcnt){
                generate(now+")",lcnt,rcnt+1,n,result);
            }
            if(lcnt<n){
                generate(now+"(",lcnt+1,rcnt,n,result);
            }
        }
    }
}