class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = Math.max(0,k-nums2.length);  
        int end = Math.min(k, nums1.length);   
        int[] result =new int[k];
        int[] tmp=null;
        for(int i=start;i<=end;i++){
            int[] sub1 = getMaxSubsequence(nums1,i); 
            int[] sub2 = getMaxSubsequence (nums2,k-i);
            tmp = merge(sub1,sub2);
            if(isGreater(tmp,0,result,0)){
                result = tmp;
            }
        }
        return result;
    }

    public int[] merge(int[] num1, int[] num2){
        int[] result = new int[num1.length+num2.length];
        int idx1=0,idx2=0,idx3=0;
        while(idx3<result.length){
            result[idx3++] = isGreater(num1,idx1,num2,idx2)? num1[idx1++]:num2[idx2++];
        }
        return result;
    }

    public boolean isGreater(int[] num1, int idx1, int[] num2, int idx2){
        while(idx1<num1.length && idx2<num2.length){
            if(num1[idx1]>num2[idx2]){
                return true;
            }else if(num2[idx2]>num1[idx1]){
                return false;
            }
            idx1++;
            idx2++;
        }
        return idx1!=num1.length;
    }

    public int[] getMaxSubsequence(int[] num, int maxSubArrCnt){
        Stack<Integer> stack = new Stack<Integer>();
        int remain =maxSubArrCnt;
        for(int i =0;i<num.length;i++){
            while(!stack.isEmpty() && stack.peek()<num[i] && num.length-1-i>=remain){
                stack.pop();
                remain++;
            }
            if(remain>0){
                stack.push(num[i]);
                remain--;
            }

        }
        int[] maxSubArr = new int[maxSubArrCnt];
        int len = maxSubArr.length-1;
        while(!stack.isEmpty()){
            maxSubArr[len--] = stack.pop();
        }
        return maxSubArr;
    }
}