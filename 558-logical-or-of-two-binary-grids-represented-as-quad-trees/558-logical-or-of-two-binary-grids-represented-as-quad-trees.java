/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf && quadTree2.isLeaf){
            if(quadTree1.val){
                return quadTree1;
            }else if(quadTree2.val){
                return quadTree2;
            }else{
                return quadTree1;
            }
        }else if(quadTree1.isLeaf){
            if(quadTree1.val){
                return quadTree1;
            }else{
                quadTree2.val = false;
                return quadTree2;
            }
        }else if(quadTree2.isLeaf){
            if(quadTree2.val){
                return quadTree2;
            }else{
                quadTree1.val = false;
                return quadTree1;
            }
        }else{
            Node topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight,quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
                return new Node(topLeft.val,true,null,null,null,null);
            }else{
                return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
            }
        }
    }
}