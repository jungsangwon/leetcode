class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int i=0; i<machines.length; i++){
            sum += machines[i];
        }
        
        if(sum%machines.length==0){
            int num = sum/machines.length;
            int[] left = new int[machines.length];
            int[] right = new int[machines.length];
            int[] limitL = new int[machines.length];
            int[] limitR = new int[machines.length];
            boolean init = true;
            for(int i=0; i<machines.length-1; i++){
                left[i+1] = left[i]+machines[i];
            }
            for(int i=machines.length-1; i>0; i--){
                right[i-1] = right[i]+machines[i];
            }
            for(int i=0; i<machines.length;i++){
                limitL[i] = num*i;
                limitR[i] = num*(machines.length-1-i);
            }
            int count = 0;
            for(int i=0;i<machines.length;i++){
                int now = 0;
                if(limitL[i]<left[i]){
                    now += left[i]-limitL[i];
                    for(int j=i-1;j>=0;j--){
                        if(machines[j]==0){
                            now++;
                        }else{
                            break;
                        }
                    }
                }
                count = Math.max(count,now);
                now=0;
                if(limitR[i]<right[i]){
                    now += right[i]-limitR[i];
                    for(int j=i+1;j<machines.length;j++){
                        if(machines[j]==0){
                            now++;
                        }else{
                            break;
                        }
                    }
                }
                if(machines[i]>num){
                    now = Math.max(now,machines[i]-num);
                }
                count = Math.max(count,now);
            }
            return count;
        }else{
            return -1;
        }
    }
}