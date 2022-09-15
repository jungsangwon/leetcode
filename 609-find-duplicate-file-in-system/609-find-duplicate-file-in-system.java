class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0; i<paths.length; i++){
            String[] t = paths[i].split(" ");
            for(int j=1; j<t.length; j++){
                String[] s =t[j].split("\\(");
                List<String> list = map.getOrDefault(s[1],new ArrayList<>());
                list.add(t[0]+"/"+s[0]);
                map.put(s[1],list);
            }
        }
        for(List<String> list : map.values()){
            if(list.size()>1){
                result.add(list);
            }
        }
        return result;
    }
}