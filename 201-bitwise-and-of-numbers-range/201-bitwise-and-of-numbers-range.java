class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShifts = 0;
        while(left!=right)
        {
            left = left >> 1;
            right = right >> 1;
            rightShifts++;
        }
        return left<<rightShifts;
    }
}