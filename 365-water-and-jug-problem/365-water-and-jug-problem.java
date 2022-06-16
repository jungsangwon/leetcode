class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity){
            return false;
        }
        int gcd = gcd(Math.max(jug1Capacity,jug2Capacity),Math.min(jug1Capacity,jug2Capacity));
        return targetCapacity % gcd == 0;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}