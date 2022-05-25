class Solution {
    class Pair{
        int val;
        int index;
        public Pair(int index, int val){
            this.val = val;
            this.index = index;
        }
    }
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> ret = new ArrayList<>();
        int l = nums.length;
        if (l == 0) return ret;
        Pair[] ps = new Pair[l];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < l; i++){
            ps[i] = new Pair(i, nums[i]); 
        }
        
        Integer[] res = new Integer[l]; // must be Integer other than int
        Arrays.fill(res, 0);            // avoid nullpointer exception
        mergeSort(ps, 0, l - 1, res);
        ret.addAll(Arrays.asList(res));
        return ret;
	}
    private Pair[] mergeSort(Pair[] arr, int start, int end, Integer[] res){
        int l = end - start + 1;
        Pair[] ret = new Pair[l];
        if (l == 0) return ret;
        if (l == 1) {
            ret[0] = arr[start];
            return ret;
        }
        
        int mid = l/2 + start;
        Pair[] left = mergeSort(arr, start, mid - 1, res);
        Pair[] right = mergeSort(arr, mid, end, res);
        
        for( int i = 0, j = 0; i < left.length || j < right.length;){
            // can not write as int j = 0, int i = 0;
            if (j == right.length || (i < left.length && left[i].val <= right[j].val) ){
                ret[i + j] = left[i];
                res[left[i].index] += j; // core of this solution
                i++;
            } else{
                ret[i + j] = right[j];
                j++;
            }
        }
        
        return ret;
    }
}
