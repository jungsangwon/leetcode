class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int numPigs = 0;
        int term = minutesToTest / minutesToDie;
        while (Math.pow(term + 1, numPigs) < buckets) {
        numPigs++;
        }
        return numPigs;
    }
}