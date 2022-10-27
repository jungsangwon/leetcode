class MagicDictionary {
    HashMap<Integer,List<String>> map;

    public MagicDictionary() {
        this.map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i=0; i<dictionary.length; i++){
            List<String> list = map.getOrDefault(dictionary[i].length(),new ArrayList<>());
            list.add(dictionary[i]);
            map.put(dictionary[i].length(),list);
        }
    }
    
    public boolean search(String searchWord) {
        List<String> list = map.get(searchWord.length());
        if(list!=null){
            for(String word : list){
                if(isDifferOneCharacter(word,searchWord)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isDifferOneCharacter(String a, String b){
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                if(count==1){
                    return false;
                }else{
                    count++;
                }
            }
        }
        return count == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */