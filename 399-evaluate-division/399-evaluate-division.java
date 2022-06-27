class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        HashMap<String,Node> map = new HashMap<>();
        for(int i=0; i<values.length; i++){
            String key1 = equations.get(i).get(0);
            String key2 = equations.get(i).get(1);
            if(!map.containsKey(key1)){
                Node node = new Node(key1);
                map.put(key1,node);
            }
            if(!map.containsKey(key2)){
                Node node = new Node(key2);
                map.put(key2,node);
            }
            map.get(key1).add(map.get(key2),values[i]);
        }
        
        for(int i=0; i<queries.size(); i++){
            String key1 = queries.get(i).get(0);
            String key2 = queries.get(i).get(1);
            if(!map.containsKey(key1)||!map.containsKey(key2)){
                result[i] = -1D;
            }else if(key1.equals(key2)){
                result[i] = 1D;
            }else{
                HashSet<Node> visit = new HashSet<>();
                visit.add(map.get(key1));
                result[i] = calculate(map.get(key1),map.get(key1),map.get(key2),1,visit);
            }
        }
        
        return result;
    }
    
    public double calculate(Node start, Node node, Node target, double now,  HashSet<Node> visit){
        if(node.link.containsKey(target)){
            now = now * node.link.get(target);
            return now;
        }else{
            for(Node next : node.link.keySet()){
                if(!visit.contains(next)){
                    double nextVal = now * node.link.get(next);
                    visit.add(next);
                    double val = calculate(start,next,target,nextVal,visit);
                    if(val!=-1D){
                        return val;
                    }
                }
            }
        }
        return -1D;
    }
}

class Node{
    HashMap<Node,Double> link;
    String key;
    public Node(String key){
        this.key = key;
        link = new HashMap<>();
    }
    
    public void add(Node n, double val){
        link.put(n,val);
        n.link.put(this,1/val);
    }
}