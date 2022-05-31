class Solution {
    public boolean hasAllCodes(String s, int k) {
        int base = '0';
        if (s.length() < k) return false;
        int total = 1 << k;
        boolean[] map = new boolean[total];
        int mask = total - 1;
        int value = Integer.parseInt(s.substring(0, k),2);
        map[value] = true;
        --total;
        for (int i = k; i < s.length(); i++) {
            value = (value << 1) + (s.charAt(i) - base);
            value &= mask;
            if (!map[value]) {
                map[value] = true;
                if (--total == 0) return true;
            }          
        }
        return false;
    }
}