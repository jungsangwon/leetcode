class Solution {
    int max = 0;
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = matrix[i][j]-'0';
            }
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                if(arr[i][j] ==1) arr[i][j] += arr[i-1][j];
            }
        }
        for(int i=0;i<m;i++){
            Stack<Integer> st = new Stack<>();
            int j=0;
            while(j<n){
                if(st.isEmpty() || arr[i][st.peek()] <= arr[i][j]) st.push(j++);
                else{
                    int top = st.pop();
                    int val = arr[i][top] * (st.isEmpty()?j:j-st.peek()-1);
                    if(max<val) max=val;
                }
            }
            while(!st.isEmpty()){
                int top = st.pop();
                int val = arr[i][top] * (st.isEmpty()?n:n-st.peek()-1);
                if(max<val) max=val;
            }
        }
        return max;
    }
}