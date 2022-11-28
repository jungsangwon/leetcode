class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Node root = new Node('1');
        int max = addWord(root,words[0].toCharArray());
        String result="";
        if(max!=0){
            result = words[0];
        }
        for(int i=1; i<words.length; i++){
            if(words[i-1].equals(words[i])){
                continue;
            }
            int tmp = addWord(root,words[i].toCharArray());
            if(max<tmp){
                max = tmp;
                result = words[i];
            }
        }
        return result;
    }
    
    public int addWord(Node root,char[] str){
        Node node = root;
        int count = 1;
        for(int i=0; i<str.length; i++){
            if(node.child[str[i]-'a']==null){
                if(i==str.length-1){
                    Node now = new Node(str[i]);
                    node.child[str[i]-'a'] = now;
                    node = now;
                }else{
                    return 0;
                }
            }else{
                node = node.child[str[i]-'a'];
                count++;
            }
        }
        node.end = true;
        return count;
    }
}

class Node{
    char c;
    Node[] child;
    boolean end;
    public Node(char c){
        this.c=c;
        this.child = new Node[26];
        this.end = false;
    }
}