class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,Node> map = new HashMap<>();
        Node node = new Node(edges[0][0]);
        map.put(edges[0][0],node);
        for(int i=0; i<edges.length; i++){
            boolean check = true;
            Node left;
            Node right;
            if(!map.containsKey(edges[i][0])){
                check = false;
                left = new Node(edges[i][0]);
                map.put(edges[i][0],left);
            }else{
                left = map.get(edges[i][0]);
            }
            if(!map.containsKey(edges[i][1])){
                check = false;
                right = new Node(edges[i][1]);
                map.put(edges[i][1],right);
            }else{
                right = map.get(edges[i][1]);
            }
            left.add(right);
            right.add(left);
            if(check){
                if(left.isCircle(left,new HashSet<>())){
                    return edges[i];
                }
            }
        }
        return null;
    }
}

class Node{
    List<Node> child;
    int key;
    public Node(int key){
        child = new ArrayList<>();
        this.key = key;
    }
    public void add(Node node){
        child.add(node);
    }
    
    public boolean isCircle(Node node,HashSet<Node> visit){
        boolean result = false;
        visit.add(this);
        for(Node c : child){
            if(c!=node){
                if(visit.contains(c)){
                    return true;
                }else{
                    result = result || c.isCircle(this,visit);
                }
                if(result){
                    return result;
                }
            }
        }
        return result;
    }
}