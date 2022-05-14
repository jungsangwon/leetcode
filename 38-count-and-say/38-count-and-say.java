class Solution {
    public String countAndSay(int n) {
        if(n!=1){
            String tmp = countAndSay(n-1);
            int count = 0;
            StringBuilder result = new StringBuilder();
            int now = Character.getNumericValue(tmp.charAt(0));
            for(int i=0; i<tmp.length(); i++){
                if(now == Character.getNumericValue(tmp.charAt(i))){
                    count++;
                }else{
                    result.append(count);
                    result.append(now);
                    count = 1;
                    now = Character.getNumericValue(tmp.charAt(i));
                }
            }
            result.append(count);
            result.append(now);
            return result.toString();
        }else{
            return "1";
        }
    }
}