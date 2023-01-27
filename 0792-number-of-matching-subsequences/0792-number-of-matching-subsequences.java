class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Node root = new Node('1');
        Node[] node = new Node[s.length()];
        for(int i=0 ; i<s.length(); i++){
            node[i] = new Node(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            root.addChild(node[i]);
            for(int j=i-1; j>=0; j--){
                if(!node[j].addChild(node[i])){
                    break;
                }
            }
        }
        
        for(int i=0; i<words.length; i++){
            if(isSubseq(root,words[i])){
                result++;
            }
        }
        return result;
    }
    
    public boolean isSubseq(Node root, String word){
        for(int i=0; i<word.length(); i++){
            Node tmp = root.child[word.charAt(i)-'a'];
            if(tmp==null){
                return false;
            }else{
                root = tmp;
            }
        }
        return true;
    }
}

class Node{
    int idx;
    Node[] child;
    public Node(char c){
        child = new Node[26];
        idx = c-'a';
    }
    
    public boolean addChild(Node node){
        if(child[node.idx]==null){
            child[node.idx] = node;
            return true;
        }
        return false;
    }
}