/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node now = head;
        childFlatten(now);
        return head;
    }
    
     public Node childFlatten(Node head) {
        Node now = head;
        while(true){
            if(now.child!=null){
                Node next = now.next;
                now.next = now.child;
                now.child.prev = now;
                Node tmp = childFlatten(now.child);
                if(next!=null){
                    next.prev = tmp;
                    tmp.next = next;
                }
                now.child = null;
            }else{
                if(now.next==null){
                    break;
                }
                now = now.next;
            }
        }
        return now;
    }
}