class Solution {
    public int compress(char[] chars) {
        int result = 1;
        int count = 1;
        char before = chars[0];
        for(int i=1; i<chars.length; i++){
            if(before == chars[i]){
                count++;
            }else{
                if(count>1){
                    char[] tmp = String.valueOf(count).toCharArray();
                    for(int j=0; j<tmp.length; j++){
                        chars[result++] = tmp[j];
                    }
                }
                chars[result++] = chars[i];
                before = chars[i];
                count = 1;
            }
        }
        if(count>1){
            char[] tmp = String.valueOf(count).toCharArray();
            for(int j=0; j<tmp.length; j++){
                chars[result++] = tmp[j];
            }
        }
        return result;
    }
}