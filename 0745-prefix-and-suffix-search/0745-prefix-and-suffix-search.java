class WordFilter {
    Node root;

    public WordFilter(String[] words) {
        root = new Node(' ');
        for(int i=0; i<words.length; i++){
            char[] tmp = words[i].toCharArray();
            Node node = root;
            for(int j=0; j<tmp.length; j++){
                if(node.child[tmp[j]-'a']!=null){
                    node = node.child[tmp[j]-'a'];
                }else{
                    Node newNode = new Node(tmp[j]);
                    node.child[tmp[j]-'a'] = newNode;
                    node = newNode;
                }
            }
            node.end = true;
            node.word = words[i];
            node.idx = i;
        }
    }
    
    public int f(String pref, String suff) {
        Node node = root;
        char[] tmp = pref.toCharArray();
        for(int i=0; i<tmp.length; i++){
            if(node.child[tmp[i]-'a']!=null){
                node = node.child[tmp[i]-'a'];
            }else{
                node = null;
                break;
            }
        }
        int result = -1;
        if(node!=null){
            result = getSuff(node,suff);
        }
        return result;
    }
    
    public int getSuff(Node node,String suff){
        int result = -1;
        if(node.end && node.word.endsWith(suff)){
            result = node.idx;
        }
        for(int i=0; i<26; i++){
            if(node.child[i]!=null){
                result = Math.max(result,getSuff(node.child[i],suff));
            }
        }
        return result;
    }
}

class Node{
    char c;
    Node[] child;
    boolean end;
    String word;
    int idx;
    public Node(char c){
        this.c = c;
        this.end = false;
        child = new Node[26];
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */