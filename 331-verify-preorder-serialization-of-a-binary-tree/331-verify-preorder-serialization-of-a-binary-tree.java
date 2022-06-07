class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] node = preorder.split(",");
        if(node.length==1&&node[0].equals("#")){
            return true;
        }
        int next = isPreorder(node,0);
        return next==node.length;
    }
    
    public int isPreorder(String[] node, int start){
        // System.out.println("idx : "+start+" -> "+node[start]);
        if(node[start++].equals("#")){
            return -1;
        }
        int next;
        if(start<node.length && !node[start].equals("#")){
            // System.out.println("left : "+start+" -> "+node[start]);
            next = isPreorder(node, start);
        }else{
            next = start+1;
        }
        if(next == -1){
            return -1;
        }
        
        if(next<node.length && !node[next].equals("#")){
            // System.out.println("right : "+next+" -> "+node[next]);
            return isPreorder(node,next);
        }else{
            if(next>=node.length){
                return -1;
            }else{
                return next+1;
            }
        }
    }
}