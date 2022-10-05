class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for(String w : dictionary){
            add(root,w);
        }
        StringBuilder sb = new StringBuilder();
        String[] word = sentence.split(" ");
        for(String w : word){
            String rep = find(root,w);
            sb.append(rep);
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
    
    public void add(Node root, String word){
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(root.child[idx]==null){
                root.child[idx] = new Node(word.charAt(i));
            }
            root = root.child[idx];
        }
        root.end = true;
    }
    
    public String find(Node root, String word){
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(root.child[idx]==null){
                return word;
            }else if(root.child[idx].end){
                return word.substring(0,i+1);
            }
            root = root.child[idx];
        }
        return word;
    }
}

class Node{
    char c;
    boolean end;
    Node[] child;
    public Node(){
        this.child = new Node[26];
    }
    public Node(char c){
        this.c=c;
        this.child = new Node[26];
    }
}