class Solution {
    public boolean detectCapitalUse(String word) {
        char[] c = word.toCharArray();
        if(isUpperCase(c[0])){
            if(c.length==1){
                return true;
            }else{
                if(isUpperCase(c[1])){
                    for(int i=2; i<c.length; i++){
                        if(!isUpperCase(c[i])){
                            return false;
                        }
                    }
                }else{
                    for(int i=2; i<c.length; i++){
                        if(isUpperCase(c[i])){
                            return false;
                        }
                    }
                }
            }
        }else{
            for(int i=1; i<c.length; i++){
                if(isUpperCase(c[i])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isUpperCase(char c){
        return c >='A' && c<='Z';
    }

}