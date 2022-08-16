class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Node root = new Node();
        Arrays.sort(words,(String a, String b) -> a.length()-b.length());
        for(String word : words){
            char[] wordC = word.toCharArray();
            if(root.isConcatenatedWords(wordC, 0, root)){
                result.add(word);
            }else{
                root.add(wordC,0);
            }
        }
        return result;
    }
}

class Node{
    Node[] child;
    boolean end;
    public Node(){
        child = new Node[26];
        end = false;
    }
    public void add(char[] word, int idx){
        Node node;
        if(child[word[idx]-'a']==null){
            node = new Node();
            child[word[idx]-'a'] = node;
        }else{
            node = child[word[idx]-'a'];
        }
        if(idx==word.length-1){
            node.end = true;
        }else{
            node.add(word,idx+1);
        }
    }
    
    public boolean isConcatenatedWords(char[] word, int idx, Node root){
        Node node;
        if(child[word[idx]-'a']==null){
            return false;
        }else{
            node = child[word[idx]-'a'];
        }
        boolean result = false;
        if(idx==word.length-1){
            return node.end==true;
        }else{
            if(node.end){
                result = root.isConcatenatedWords(word,idx+1,root);
            }
            result = result || node.isConcatenatedWords(word,idx+1,root);
        }
        return result;
    }
}