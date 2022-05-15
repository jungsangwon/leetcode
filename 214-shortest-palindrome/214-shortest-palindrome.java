class Solution {
    public String shortestPalindrome(String s) {
        // System.out.println(s);
        int first = 0;
        int last = s.length()-1;
        boolean result = true;
        while(first<=last){
            if(s.charAt(first)!=s.charAt(last)){
                result = false;
                break;
            }
            first++;
            last--;
        }
        if(result){
            return s;
        }else{
            while(first>0){
                if(s.charAt(--first)==s.charAt(last)){
                    last++;
                }
            }
            String tmp = s.substring(last,s.length());
            StringBuilder st = new StringBuilder(tmp).reverse();
            // System.out.println("tmp : "+tmp);
            return st.toString()+shortestPalindrome(s.substring(first,last)) + tmp;
        }
    }
}