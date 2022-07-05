class Solution {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int i=0; i<nums.length; i++){
            int[] c = new int[32];
            int idx = 31;
            while(nums[i]>0){
                c[idx--] = nums[i]%2;
                nums[i] = nums[i] / 2;
            }
            root.add(c,0);
        }
        return getMax(root,root,0,0);
    }
    public int getMax(Node num1, Node num2, int now, int count){
        int result = 0;
        if(count==32){
            return now;
        }
        boolean check = false;
        if(num1.child[0]!=null && num2.child[1]!=null){
            result = getMax(num1.child[0], num2.child[1], (now*2)+1, count+1);
            check = true;
        }
        if(num1.child[1]!=null && num2.child[0]!=null){
            result = Math.max(result,getMax(num1.child[1], num2.child[0], (now*2)+1, count+1));
            check = true;
        }
        if(!check){
            if(num1.child[0]!=null){
                result = getMax(num1.child[0],num2.child[0],now*2, count+1);
            }else{
                result = getMax(num1.child[1],num2.child[1],now*2, count+1);
            }
        }
        
        return result;
    }
}

class Node{
    Node[] child;
    
    public Node(){
        child = new Node[2];
    }
    
    public void add(int[] c, int idx){
        if(idx < c.length){
            int num = c[idx];
            Node node;
            if(child[num]==null){
                node = new Node();
                child[num] = node;
            }else{
                
                node = child[num];
            }
            node.add(c,idx+1);
        }
    }
    
}