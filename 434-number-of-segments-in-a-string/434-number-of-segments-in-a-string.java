class Solution {
    public int countSegments(String s) {
        String[] str = s.split(" ");
        int count = 0;
        for(String t : str){
            if(t.length()!=0){
                count++;
            }
        }
        return count;
    }
}