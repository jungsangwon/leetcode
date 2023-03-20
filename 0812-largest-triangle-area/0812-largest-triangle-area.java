class Solution {
    public double largestTriangleArea(int[][] points) {
        double result = 0D;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                for(int k=j+1; k<points.length; k++){
                    result = Math.max(result, largestTriangleArea(points[i],points[j],points[k]));
                }
            }
        }
        return result;
    }
    
    public double largestTriangleArea(int[] a, int[] b, int[] c){
        double result = a[0]*b[1]+b[0]*c[1]+c[0]*a[1] - (a[0]*c[1]+b[0]*a[1]+c[0]*b[1]);
        return Math.abs(result)/2;
    }
}