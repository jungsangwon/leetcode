/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        distanceK(root,target,k,result);
        return result;
    }
    
    public int distanceK(TreeNode root, TreeNode target, int k, List<Integer> list) {
        int left = -1;
        int right = -1;
        if(root == target){
            getChild(root,list,k);
            return 1;
        }else{
            if(root.left!=null){
                left = distanceK(root.left,target,k,list);
            }
            if(root.right!=null){
                right = distanceK(root.right,target,k,list);
            }
            int now = Math.max(left,right);
            // System.out.println(root.val+" : "+left+", "+right);
            if(now!= -1 && now<k){
                if(left!= -1&&root.right!=null){
                    getChild(root.right,list,k-now-1);
                }else if(right !=-1&&root.left!=null){
                    getChild(root.left,list,k-now-1);
                }
            }else if(now == k){
                list.add(root.val);
            }
            if(now==-1){
                return -1;
            }else{
                return now+1;
            }
        }
        
    }
    
    public void getChild(TreeNode root, List<Integer> list, int k){
        if(k==0){
            list.add(root.val);
        }else{
            if(root.left!=null){
                getChild(root.left, list, k-1);
            }
            if(root.right!=null){
                getChild(root.right, list, k-1);
            }
        }
    }
}