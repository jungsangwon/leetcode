class Solution {
    public int distributeCandies(int[] candyType) {
        int max = candyType.length/2;
        int count = 0;
        int before = Integer.MIN_VALUE;
        Arrays.sort(candyType);
        for(int i=0; i<candyType.length; i++){
            if(candyType[i]!=before){
                count++;
                before = candyType[i];
            }
        }
        return Math.min(max,count);
    }
}