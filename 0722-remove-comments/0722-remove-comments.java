class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean block = false;
        String before ="";
        int now = 0;
        for(int i=0; i<source.length; i++){
            now = i;
            if(block){
                int end = source[i].indexOf("*/");
                if(end>=0){
                    source[i] = source[i].substring(end+2);
                    i--;
                    block=false;
                }else{
                    continue;
                }          
            }else{
                int tmp = source[i].indexOf("//");
                int start = source[i].indexOf("/*");
                if(tmp>=0 && (start<0 || tmp<start)){
                    source[i] = source[i].substring(0,tmp);
                }else if(start>=0){
                    before += source[i].substring(0,start);
                    source[i] = source[i].substring(start+2);
                    i--;
                    block =true;
                }
            }
            if(i==now){
                String add = before+source[i];
                if(add.length()!=0){
                    result.add(before+source[i]);
                }
                before="";
            }
        }
        return result;
    }
}