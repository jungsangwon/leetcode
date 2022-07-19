class Solution {
    public String frequencySort(String s) {
        char[] c = s.toCharArray();
        int[][] count = new int[26][2];
        int[] num = new int[10];
        for(int i=0; i<c.length; i++){
            if(c[i]<='9'&&c[i]>='0'){
                num[c[i]-'0']++;
            }else if(c[i]>='A'&&c[i]<='Z'){
                count[c[i]-'A'][0]++;
            }else{
                count[c[i]-'a'][1]++;
            }
        }
        TreeMap<Integer,List<Character>> map = new TreeMap<>(Collections.reverseOrder());
        for(int j=0; j<10; j++){
            List<Character> list = map.getOrDefault(num[j],new ArrayList<>());
            list.add((char)(j+'0'));
            map.put(num[j],list);
        }
        for(int j=0; j<26; j++){
            List<Character> list = map.getOrDefault(count[j][0],new ArrayList<>());
            list.add((char)(j+'A'));
            map.put(count[j][0],list);
            
            list = map.getOrDefault(count[j][1],new ArrayList<>());
            list.add((char)(j+'a'));
            map.put(count[j][1],list);
        }
        StringBuilder sb = new StringBuilder();
        for(int key : map.keySet()){
            List<Character> list = map.get(key);
            for(char t : list){
                for(int i=0; i<key; i++){
                    sb.append(t);
                }
            }
        }
        return sb.toString();
    }
}