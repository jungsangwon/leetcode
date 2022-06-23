class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        lexicalOrder(1,n,result);
        return result;
    }
    
    public void lexicalOrder(int n, int max, List<Integer> result) {
        result.add(n);
        if(n*10<=max){
            lexicalOrder(n*10,max,result);
            if(n%10!=9){
                lexicalOrder(n+1,max,result);
            }
        }else if(n<max&&n%10!=9){
            lexicalOrder(n+1,max,result);
        }
    }
}