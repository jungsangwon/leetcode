class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] sum = new int[matrix.length][matrix[0].length+1];
        for(int i=0; i<matrix.length; i++){
            for(int j=0;j<matrix[i].length; j++){
                sum[i][j+1] = sum[i][j] + matrix[i][j];
            }
        }
        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[0].length; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println("");
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<=matrix.length; i++){
            for(int j=0; j<=matrix[0].length;j++){
                for(int a=1; a<=matrix[0].length-j;a++){
                    int tmp = 0;
                    for(int t=0; t<matrix.length-i; t++){
                        tmp += sum[i+t][j+a] - sum[i+t][j];
                        // System.out.println("i : "+i+" j :"+j+" t : "+t+" a : "+a+" = "+tmp);
                        if(tmp == k){
                            return k;
                        }else if(tmp<k && tmp>result){
                            result = tmp;
                        }
                    }
                }
            }
        }
        return result;
    }
}