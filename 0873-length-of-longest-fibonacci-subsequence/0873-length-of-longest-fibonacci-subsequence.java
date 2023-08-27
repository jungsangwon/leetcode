class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int result = 0;
        Arrays.sort(arr);
        boolean[][] check = new boolean[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int first = i;
                int second = j;
                int count = 0;
                int next = getNext(arr,i,j);
                while(!check[first][second] && next!=-1){
                    count++;
                    check[first][second] = true;
                    first = second;
                    second = next;
                    next = getNext(arr,first,second);
                }
                if(count!=0){
                    result = Math.max(result,count+2);
                }
            }
        }
        return result;
    }
    
    public int getNext(int[] arr, int i, int j){
        int target = arr[i]+arr[j];
        int left = j+1;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right) / 2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}