class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            check(strs[i],map);
        }
        result.addAll(map.values());
        return result;
    }
    
    public void check(String str, HashMap<String,List<String>> map){
        int[] check = new int[26];
        char[] charList = str.toCharArray();
        Arrays.sort(charList);
        List<String> tmp = map.getOrDefault(String.valueOf(charList), new ArrayList<>());
        tmp.add(str);
        map.put(String.valueOf(charList),tmp);
    }
}