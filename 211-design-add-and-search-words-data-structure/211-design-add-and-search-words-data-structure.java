class WordDictionary {
    HashMap<Character, WordDictionary> hashMap;
    boolean end = false;

    public WordDictionary() {
        hashMap = new HashMap<>();
    }
    
    public void addWord(String word) {
        addWord(word,0);
    }
    
    public void addWord(String word, int i){
        if(word.length()-1==i){
            if(hashMap.containsKey(word.charAt(i))){
                hashMap.get(word.charAt(i)).end = true;
            }else{
                WordDictionary node = new WordDictionary();
                node.end = true;
                hashMap.put(word.charAt(i),node);
            }
        }else if(word.length()-1>i){
            if(hashMap.containsKey(word.charAt(i))){
                hashMap.get(word.charAt(i)).addWord(word,i+1);
            }else{
                WordDictionary node = new WordDictionary();
                hashMap.put(word.charAt(i),node);
                node.addWord(word,i+1);
            }
        }
    }
    
    public boolean search(String word) {
        return search(word,0);
    }
    
    public boolean search(String word, int i){
        if(word.length()-1>i){
            if(word.charAt(i)=='.'){
                boolean result = false;
                for(WordDictionary node : hashMap.values()){
                    if(!result){
                        result = node.search(word,i+1);
                    }else{
                        break;
                    }
                }
                return result;
            }else if(hashMap.containsKey(word.charAt(i))){
                return hashMap.get(word.charAt(i)).search(word,i+1);
            }else{
                return false;
            }
        }else{
            if(word.charAt(i)=='.'){
                for(WordDictionary node : hashMap.values()){
                    if(node.end){
                        return true;
                    }
                }
                return false;
            }else if(hashMap.containsKey(word.charAt(i))){
                return hashMap.get(word.charAt(i)).end;
            }else{
                return false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */