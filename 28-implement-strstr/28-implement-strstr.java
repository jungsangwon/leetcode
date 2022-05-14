class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        int[] pi = getPi(needle);
        
        int n1 = haystack.length();
	    int n2 = needle.length();
		
        int idx = 0;
        for(int i=0; i< n1; i++) {
            while(idx>0 && haystack.charAt(i) != needle.charAt(idx)) {
                idx = pi[idx-1];
            }
            if(haystack.charAt(i) == needle.charAt(idx)) {
                if(idx == n2-1) {
                    return i - idx;
                }else {
                    idx += 1;
                }
            }
        }
        
        return -1;
    }
    
    public int[] getPi(String needle){
        int len =needle.length();
        int[] pi = new int[len];
        int j = 0;
        for(int i=1; i<len; i++) {
			while(j > 0 && needle.charAt(i) != needle.charAt(j)) { 
				j = pi[j-1];                                        
			}if(needle.charAt(i) == needle.charAt(j)) {            
				pi[i] = ++j;                                         
			}
		}
        return pi;
    }
}