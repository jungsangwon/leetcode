class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st = new StringBuilder();
        int tmp = 64;
        while(columnNumber!=0){
            int now = columnNumber % 26;
            columnNumber = columnNumber/26;
            if(now == 0){
                st.insert(0,"Z");
                columnNumber--;
            }else{
                char c = (char)(now+64);
                st.insert(0,c);
            }
        }
        return st.toString();
    }
}