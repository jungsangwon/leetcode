class MapSum {
    HashMap<String,Integer> map;
    Node root;

    public MapSum() {
        map = new HashMap<>();
        root = new Node(' ');
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
        root.add(key.toCharArray(),0);
    }
    
    public int sum(String prefix) {
        int num = 0;
        Node node = search(prefix);
        if(node!=null){
            List<String> result = new ArrayList<>();
            node.getAllChild(result);
            for(String s : result){
                num += map.get(s);
            }
        }
        return num;
    }
    
    public Node search(String prefix){
        Node node = root;
        char[] c = prefix.toCharArray();
        for(int i=0; i<c.length; i++){
            if(node.child[c[i]-'a']!=null){
                node = node.child[c[i]-'a'];
            }else{
                return null;
            }
        }
        return node;
    }
}

class Node{
    Node[] child;
    char c;
    boolean end;
    String str;
    
    public Node(char c){
        child = new Node[26];
        this.c=c;
        end = false;
        str = "";
    }
    
    public void add(char[] word, int idx){
        if(idx == word.length){
            end = true;
            str = String.valueOf(word);
        }else{
            if(child[word[idx]-'a']==null){
                Node node = new Node(word[idx]);
                child[word[idx]-'a'] = node;
                node.add(word,idx+1);
            }else{
                child[word[idx]-'a'].add(word,idx+1);
            }
        }
    }
    
    public void getAllChild(List<String> result){
        if(end){
            result.add(str);
        }
        for(int i=0; i<26; i++){
            if(child[i]!=null){
                child[i].getAllChild(result);
            }
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */