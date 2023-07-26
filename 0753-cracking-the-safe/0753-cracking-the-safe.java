class Solution {
    public String crackSafe(int n, int k) {
        HashSet<String>v=new HashSet<>();
        String ans="";
        for(int i=0;i<n;i++) ans+='0';
        int len = n + (int)Math.pow(k,n) - 1;
        ans=dfs(ans,n,k,v,len);
        return ans;
    }
    public String dfs(String s,int n, int k, HashSet<String> v, int len)
    {
        int l=s.length();
        v.add(s.substring(l-n,l));
        for(int i=0;i<k;i++){
            if(!v.contains(s.substring(l-n+1)+Integer.toString(i))){
                String temp = dfs(s+Integer.toString(i),n,k,v,len);
                if(temp.length()==len){
                    s=temp;
                    break;
                }
                v.remove(s.substring(l-n+1)+Integer.toString(i));
            }
        }
        return s;
    }
}