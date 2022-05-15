class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int tmp = numbers[left]+numbers[right];
            if(tmp == target){
                result[0] = left+1;
                result[1] = right+1;
                break;
            }else if(tmp>target){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }
}