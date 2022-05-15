class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 1; i <= n; i *= 10) {
            int l = n / i, r = n % i;   // n = 6543210; and i = 100000;  --> l = 65; and r = 43210;
            int numFullCycles = l / 10;
            int sizeOfOneFullCycle = i;
            int sizeOfLastPartialCycle = (l % 10 >= 2) ? sizeOfOneFullCycle : (l % 10 == 1) ? r + 1 : 0;
            result += numFullCycles * sizeOfOneFullCycle + sizeOfLastPartialCycle;
        }
        return result;
    }
    
}