class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        
        while(true){
            if(left == right){
                break;
            }
            int area = Math.min(height[left],height[right]) * (right-left);
            if(area>max){
                max = area;
            }
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
            
        }
        
        return max;
    }
}