class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        int left = heaters[0];
        int right = heaters.length>1?heaters[1] : Integer.MAX_VALUE;
        int idx = 1;
        for(int i=0; i<houses.length; i++){
            while(houses[i]>=right&&idx<heaters.length-1){
                left = right;
                right = heaters[++idx];
            }
            if(houses[i]<left){
                result = Math.max(result, left - houses[i]);
                // System.out.println(left - houses[i]);
            }else if(houses[i]>right){
                result = Math.max(result, houses[i] - right);
                // System.out.println(houses[i] - right);
            }else{
                result = Math.max(result,Math.min(houses[i]-left,right-houses[i]));
                // System.out.println(Math.min(houses[i]-left,right-houses[i]));
            }
        }
        return result;
    }
}