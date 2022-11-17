class MyLinkedList {
    int size = 0;
    Node root;

    public MyLinkedList() {
        this.root = new Node();
    }
    
    public int get(int index) {
        if(index>=size){
            return -1;
        }else{
            Node node = root;
            for(int i=0; i<=index; i++){
                node = node.next;
            }
            return node.val;
        }
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
        
    }
    
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index<=size){
            Node node = new Node(val);
            Node now = root;
            for(int i=0; i<index; i++){
                now = now.next;
            }
            node.next = now.next;
            now.next = node;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index<size){
            Node before = root;
            Node now = root.next;
            for(int i=0; i<index; i++){
                before = before.next;
                now = now.next;
            }
            before.next = now.next;
            size--;
        }
    }
}

class Node{
    Node next;
    int val;
    public Node(){
        
    }
    public Node(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */