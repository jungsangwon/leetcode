class Solution {
    static HashMap<String,Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        
        if(s1.equals(s2))
        {
            return true;
        }
             
        String key=s1+"_"+s2;
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        boolean flag=false;
        int n=s1.length();
        for(int i=1;i<n;i++)
        {
             boolean swap=(isScramble(s1.substring(0, i),s2.substring(n - i,n)) && isScramble(s1.substring(i, n),s2.substring(0, n-i)));
         
            boolean noswap=(isScramble(s1.substring(0, i),s2.substring(0, i))  && isScramble(s1.substring(i, n),s2.substring(i, n)));
            
            if(noswap||swap)
            {
                flag=true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
    }
}