class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z\s]"," ");
        HashMap<String,Integer> count = new HashMap<>();
        String[] words = paragraph.split(" ");
        for(String word : words){
            String tmp = word.toLowerCase();
            count.put(tmp,count.getOrDefault(tmp,0)+1);
        }
        for(String word : banned){
            count.remove(word);
        }
        count.remove("");
        String result = "";
        int cnt = 0;
        for(String word : count.keySet()){
            // System.out.println(word+" : "+count.get(word));
            int tmp = count.get(word);
            if(tmp>cnt){
                result = word;
                cnt = tmp;
            }else if(tmp==cnt){
                if(result.compareTo(word)<0){
                    result = word;
                }
            }
        }
        return result;
    }
}