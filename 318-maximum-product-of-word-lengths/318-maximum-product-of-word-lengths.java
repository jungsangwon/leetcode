class Solution {
    public int maxProduct(String[] words) {
         if(words == null || words.length < 2) {
            return 0;
        }
        int length = words.length;
        int[] bitValues = new int[length];
        for(int i=0;i<length;i++) {
            String word = words[i];
            for(char letter: word.toCharArray()) {
                bitValues[i] |= 1 << (letter - 'a');
            }
        }
        int max = 0;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++) {
                if((bitValues[i] & bitValues[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}