/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        int len = 0;
        Node result = null;
        if(head == null){
            return null;
        }else{
            result = new Node(head.val);
        }
        Node before = result;
        Node now = head;
        now = now.next;
        HashMap<Integer,Node> map = new HashMap<>();
        map.put(len,before);
        while(now!=null){
            Node tmp = new Node(now.val);
            before.next = tmp;
            before = tmp;
            now = now.next;
            map.put(++len,tmp);
        }
        now = head;
        int idx = 0;
        while(now!=null){
            int count = 0;
            Node tmp = now.random;
            if(tmp == null){
                map.get(idx++).random = null;
            }else{
                while(tmp!=null){
                    tmp = tmp.next;
                    count++;
                }
                map.get(idx++).random = map.get(len-count+1);
            }
            now = now.next;
        }
        return result;
    }
}