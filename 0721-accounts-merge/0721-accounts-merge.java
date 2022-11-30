class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,Node> map = new HashMap<>();
        Node root = new Node("root");
        
        for(List<String> account : accounts){
            Node before = root;
            String name = account.get(0);
            for(int i=1; i<account.size(); i++){
                String email = account.get(i);
                Node next;
                if(map.containsKey(email)){
                    next = map.get(email);
                }else{
                    next = new Node(name,email);
                    map.put(email,next);
                }
                before.child.add(next);
                next.child.add(before);
                before = next;
            }
        }
        root.visit = true;
        for(Node node : root.child){
            if(!node.visit){
                List<String> list = new ArrayList<>();
                node.getResult(list);
                Collections.sort(list);
                list.add(0,node.name);
                result.add(list);
            }
        }
        return result;
    }
}

class Node{
    String name;
    String email;
    List<Node> child;
    boolean visit;
    public Node(String name){
        this.name = name;
        this.visit = false;
        child = new ArrayList<>();
    }
    public Node(String name, String email){
        this.name = name;
        this.email = email;
        this.visit = false;
        child = new ArrayList<>();
    }
    public void getResult(List<String> list){
        list.add(email);
        this.visit = true;
        for(Node node : child){
            if(!node.visit){
                node.getResult(list);
            }
        }
    }
}