class Solution {
    int count = 0;
    int lb;
    int ub;
    long[] temp;
    // be aware 
    long[] nums; // use long since we are recording sum and nums migh be at limit of int
    
    public int countRangeSum(int[] ns, int lower, int upper) {
        // dp or merge"sum" of elements between lower and upper, O(nlogn) time complexity
        // in merge"sum" the left and right half was already counted, then we pick one from left and one from right and 
        // work on presum, then the subarray sum equals preSum(i) - preSum(j)
        // each merge subproblem is equal to finding n1[i] - n2[j] within range in 2 sorted arrays
        lb = lower;
        ub = upper;
        temp = new long[ns.length+1];
        nums = new long[ns.length+1];
        
        nums[0] = 0;
        for(int i = 0; i < ns.length; i++) {
            nums[i+1] = nums[i] + ns[i];
        }
        sort(0, nums.length-1);
        return count;
    }
    
    // merge sort implementation
    private void sort(int l, int h) {
        if(l == h) return;
        
        int mid = l+(h-l)/2;
        
        // with recursion, the index range cases not on each halves have already been checked
        sort(l,mid);
        sort(mid+1,h);
        merge(l,h,mid);
    }
    
    // merge with counting items within range
    private void merge(int l, int h, int mid) {
        // copy sorted value to temp
        for(int i = l; i <= h; i++) {
            temp[i] = nums[i];
        }
        
        // counting range sums index
        // checking anything in range on 2 sorted arrays
        int x=l;
        int yl = mid+1;
        int yh = mid+1;
        while(x < mid+1) {
            long xNum = temp[x];
            while(yl <= h && temp[yl] - xNum < lb) {
                yl++;
            }
            while(yh <=h && temp[yh] - xNum <= ub) {
                yh++;
            }
            count+=yh-yl;
            x++;
        }
        
        // regular merge sort 
        int i = l;
        int j = mid+1;
        
        for(int p = l; p <= h; p++) {
            if(i == mid+1) {
                nums[p]=temp[j++];
            } else if(j == h+1) {
                nums[p]=temp[i++];
            } else if(temp[i] <= temp[j]) {
                nums[p] = temp[i++];
            } else {
                nums[p] = temp[j++];
            }
        }
    }
}