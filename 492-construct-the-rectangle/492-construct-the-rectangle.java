class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        for(int i=1; i<=area; i++){
            if(area/i<i){
                break;
            }else{
                if(area%i==0){
                    result[0] = area/i;
                    result[1] = i;
                }
            }
        }
        return result;
    }
}