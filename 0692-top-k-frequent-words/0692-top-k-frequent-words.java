class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        TreeMap<Integer,PriorityQueue<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(String key:map.keySet()){
            PriorityQueue<String> pq = treeMap.getOrDefault(map.get(key),new PriorityQueue<>());
            pq.add(key);
            treeMap.put(map.get(key),pq);
        }
        for(int count : treeMap.keySet()){
            if(k==0){
                break;
            }
            PriorityQueue<String> pq = treeMap.get(count);
            while(!pq.isEmpty() && k!=0){
                result.add(pq.poll());
                k--;
            }
        }
        return result;
    }
}