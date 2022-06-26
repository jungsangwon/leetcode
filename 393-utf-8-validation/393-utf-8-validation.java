class Solution {
    public boolean validUtf8(int[] data) {
        // for(int i=0; i<data.length; i++){
        //     System.out.println(i+" -> "+data[i]);
        // }
        int count = 0;
        int i = 0;
        while(i<data.length){
            for(; i<data.length; i++){
                if(data[i]>247){
                    return false;
                }else{
                    int tmp = 128;
                    int now = data[i];
                    while(true){
                        if(now>=tmp){
                            count++;
                            now-=tmp;
                            tmp=tmp/2;
                        }else{
                            break;
                        }
                    }
                    break;
                }
            }
            if(count>1){
                count--;
            }
            i++;
            // System.out.println(count+" "+i);
            if(count>data.length-i){
                return false;
            }
            for( ; count>0; count--){
                if(data[i]>=128 && data[i]<=191){
                    i++;
                }else{
                    return false;
                }
            }
        }
        
        return count==0;
    }
}