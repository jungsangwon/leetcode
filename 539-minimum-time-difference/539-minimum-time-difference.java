class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (String a, String b)->getValue(a)-getValue(b));
        int result = 1440-getValue(timePoints.get(timePoints.size()-1)) + getValue(timePoints.get(0));
        for(int i=1; i<timePoints.size();i++){
            result = Math.min(result, getValue(timePoints.get(i)) - getValue(timePoints.get(i-1)));
        }
        return result;
    }
    
    public int getValue(String time){
        String[] str = time.split(":");
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
}