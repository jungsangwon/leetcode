class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(beginWord==null || beginWord.length()==0){
            return result;            
        }
        if(endWord==null || endWord.length()==0){
            return result;            
        }
        wordList.add(0,beginWord);
        HashMap<String, HashMap<String,Integer>> map = new HashMap<>();
        for(int i=0; i<wordList.size(); i++){
            for(int j=i+1; j<wordList.size(); j++){
                if(isDifferOneletter(wordList.get(i),wordList.get(j))){
                    HashMap<String,Integer> tmp = map.getOrDefault(wordList.get(i),new HashMap<>());
                    tmp.put(wordList.get(j),j);
                    map.put(wordList.get(i),tmp);
                    tmp = map.getOrDefault(wordList.get(j),new HashMap<>());
                    tmp.put(wordList.get(i),i);
                    map.put(wordList.get(j),tmp);
                }
            }
        }
        int target = -1;
        for(int i = 1 ; i<wordList.size(); i++){
            if(endWord.equals(wordList.get(i))){
                target = i;
                break;
            }
        }
        if(target==-1){
            return result;
        }
        List<List<String>> list = new ArrayList<>();
        List<List<String>> next = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        next.add(tmp);
        
        boolean finish = false;
        while(true){
            for(int idx=0; idx<next.size(); idx++){
                List<String> now = next.get(idx);
                String str = now.get(now.size()-1);
                if(!map.containsKey(str)){
                    continue;
                }
                for(String word : map.get(str).keySet()){
                    int i = map.get(str).get(word);
                    now.add(word);
                    if(i == target){
                        result.add(new ArrayList<>(now));
                        finish = true;
                    }else{
                        list.add(new ArrayList<>(now));
                    }
                    now.remove(now.size()-1);
                }
            }
            next = new ArrayList<>();
            if(list.isEmpty()){
                break;
            }else{
                for(int i=0; i<list.size(); i++){
                    List<String> tmpList = list.get(i);
                    next.add(tmpList);
                    map.remove(tmpList.get(tmpList.size()-2));
                }
            }
            list = new ArrayList<>();
            if(finish){
                break;
            }
        }
        
        return result;
    }
    
    public boolean isDifferOneletter(String a, String b){
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
            }
        }
        if(count==1){
            return true;
        }else{
            return false;
        }
    }
    
}