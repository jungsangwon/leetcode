import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0D;
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int sum = len1+len2;
        int[] nums = new int[sum];
        int idx1 = 0;
        int idx2 = 0;
        int index = 0;
        for(; index<sum; index++){
            if(idx1 == len1 || idx2 == len2){
                break;
            }
            if(nums1[idx1]>nums2[idx2]){
                nums[index] = nums2[idx2];
                idx2++;
            }else{
                nums[index] = nums1[idx1];
                idx1++;
            }
        }
        if(idx1 != len1){
            for(;index<sum; index++){
                nums[index] = nums1[idx1];
                idx1++;
            }
        }else{
            for(;index<sum; index++){
                nums[index] = nums2[idx2];
                idx2++;
            }
        }
        if(sum%2 == 0){
            result += nums[sum/2 - 1];
            result += nums[sum/2];
            result = result / 2;
        }else{
            result += nums[sum/2];
        }
//         PriorityQueue<Integer> qu = new PriorityQueue<>();
//         for(int i=0; i<len1; i++){
//             qu.add(nums1[i]);
//         }
//         for(int i=0; i<len2; i++){
//             qu.add(nums2[i]);
//         }
//         int sum = len1 + len2;
//         int mid = sum /2;
//         if(sum%2 == 0){
//             mid--;
//         }
        
//         for(int i=0; i<mid; i++){
//             qu.poll();
//         }
        
//         result += qu.poll();
//         if(sum%2 == 0){
//             result += qu.poll();
//             result = result / 2;
//         }
        
        return result;
    }
}