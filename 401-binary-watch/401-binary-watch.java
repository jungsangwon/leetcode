class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        int[] hour = new int[12];
        int[] minute = new int[60];
        for(int i=0; i<12; i++){
            int count = 0;
            int now = i;
            while(now>0){
                if(now%2==1){
                    count++;
                }
                now = (now/2);
            }
            hour[i] = count;
        }
        
        for(int i=0; i<60; i++){
            int count = 0;
            int now = i;
            while(now>0){
                if(now%2==1){
                    count++;
                }
                now = (now/2);
            }
            minute[i] = count;
        }
        
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                if(minute[j] == turnedOn-hour[i]){
                    String res = i+":";
                    if(j<=9){
                        res += "0";
                    }
                    res += j;
                    result.add(res);
                }
            }
        }
        
        return result;
    }
}