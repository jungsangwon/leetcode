class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        String[] list = s.trim().split(" ");
        result = list[list.length-1].length();
        return result;
    }
}