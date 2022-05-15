class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0) {
            return 0;
        }
        if (endWord == null || endWord.length() == 0){
            return 0;
        }
        if (beginWord.length() != endWord.length()){
            return 0;
        }
        int result = 0;
        wordList.add(0,beginWord);
        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0; i<wordList.size(); i++){
            for(int j=i+1; j<wordList.size(); j++){
                if(isDifferOneletter(wordList.get(i),wordList.get(j))){
                    HashMap<Integer,Integer> tmp = map.getOrDefault(i,new HashMap<>());
                    tmp.put(j,1);
                    map.put(i,tmp);
                    tmp = map.getOrDefault(j,new HashMap<>());
                    tmp.put(i,1);
                    map.put(j,tmp);
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
        Queue<Integer> qu = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();
        next.add(0);
        
        int count = 1;
        boolean finish = false;
        int[] check = new int[wordList.size()];
        check[0] = 1;
        while(true){
            count++;
            while(!next.isEmpty()){
                int now = next.poll();
                if(!map.containsKey(now)){
                    continue;
                }
                for(int i : map.get(now).keySet()){
                    if(check[i]==0){
                        check[i]=1;
                        qu.add(i);
                        if(i == target){
                            finish = true;
                            break;
                        }
                    }
                }
            }
            if(qu.isEmpty() || finish){
                break;
            }else{
                while(!qu.isEmpty()){
                    next.add(qu.poll());
                }
            }
        }
        if(finish){
            result = count;
        }
        
        return result;
    }
    
    public boolean isDifferOneletter(String a, String b){
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
                if(count>1){
                    break;
                }
            }
        }
        if(count==1){
            return true;
        }else{
            return false;
        }
    }
}