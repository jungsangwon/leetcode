class Solution {
    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        for(String word : words){
            char[] c = word.toCharArray();
            Node tmp = root;
            for(int i=c.length-1; i>=0; i--){
                int idx = c[i]-'a';
                if(tmp.child[idx]==null){
                    Node newNode = new Node();
                    tmp.child[idx] = newNode;
                    tmp.end = false;
                }
                tmp = tmp.child[idx];
            }
        }
        return getDepth(root,0);
    }
    
    public int getDepth(Node node, int now){
        if(node.end){
            return now+1;
        }else{
            int result = 0;
            for(int i=0; i<26; i++){
                if(node.child[i]!=null){
                    result += getDepth(node.child[i],now+1);
                }
            }
            return result;
        }
    }
}

class Node{
    Node[] child;
    boolean end;
    public Node(){
        child = new Node[26];
        end = true;
    }
}