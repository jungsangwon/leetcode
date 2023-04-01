class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] c = s.toCharArray();
        char before = c[0];
        int start = 0;
        for(int i=1; i<c.length; i++){
            if(before != c[i]){
                if(i-start>=3){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(start);
                    tmp.add(i-1);
                    result.add(tmp);
                }
                before = c[i];
                start = i;
            }
        }
        if(c.length-start>=3){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(start);
            tmp.add(c.length-1);
            result.add(tmp);
        }
        return result;
    }
}