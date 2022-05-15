class Trie {
    HashMap<Character, Trie> children;
    char c;
    boolean end = false;

    public Trie() {
        children = new HashMap<>();
    }
    
    public Trie(char c){
        children = new HashMap<>();
        this.c = c;
    }
    
    public void insert(String word) {
        if(word.length()>0){
            if(children.containsKey(word.charAt(0))){
                children.get(word.charAt(0)).insert(word.substring(1,word.length()));
            }else{
                Trie trie = new Trie(word.charAt(0));
                children.put(word.charAt(0),trie);
                trie.insert(word.substring(1,word.length()));
            }
        }else{
            this.end = true;
        }
    }
    
    public boolean search(String word) {
        if(word.length()==0){
            return this.end;
        }else{
            if(children.containsKey(word.charAt(0))){
                return children.get(word.charAt(0)).search(word.substring(1,word.length()));
            }else{
                return false;                
            }
        }
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length()==0){
            return true;
        }else{
            if(children.containsKey(prefix.charAt(0))){
                return children.get(prefix.charAt(0)).startsWith(prefix.substring(1,prefix.length()));
            }else{
                return false;                
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */