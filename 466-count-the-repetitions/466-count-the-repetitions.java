class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int nn1 = s1.length();
        int nn2 = s2.length();
        
        int[][] records = new int[2][n1+1];
        Arrays.fill(records[0], -1);
        int index2 = 0, count = 0;
        int cycleStart = -1, cycleEnd = -1, cycleCount = -1;
        for (int i = 1; i <= n1; i++) {
            for (int j = 0; j < nn1; j++) {
                if (s1.charAt(j) == s2.charAt(index2)) {
                    index2++;
                }
                if (index2 == nn2) {
                    index2 = 0;
                    count++;
                }
            }
            for (int k = 1; k < i; k++) {
                if (records[0][k] == index2) { 
                    cycleStart = k;
                    cycleEnd = i;
                    cycleCount = count - records[1][k];
                }
            }
            if (cycleStart != -1) {
                break;
            }
            records[0][i] = index2;
            records[1][i] = count;
        }
        
        if (cycleStart == -1) {
            return count / n2;
        }
        
        int res = 0;
        int cycleN = (n1 - cycleStart) / (cycleEnd - cycleStart);
        res = cycleN * cycleCount;
        // snitich pre-cycle and post-cycle parts
        res += records[1][n1 - cycleN * (cycleEnd - cycleStart)];
        
        return res / n2;
    }
}