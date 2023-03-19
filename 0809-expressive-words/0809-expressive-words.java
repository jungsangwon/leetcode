class Solution {
    public int expressiveWords(String s, String[] words) {
        int result = 0;
        List<Character> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        char[] c =s.toCharArray();
        char before = c[0];
        int cnt = 1;
        for(int i=1; i<c.length; i++){
            if(before!=c[i]){
                list.add(before);
                count.add(cnt);
                before = c[i];
                cnt=1;
            }else{
                cnt++;
            }
        }
        list.add(before);
        count.add(cnt);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)+" : "+count.get(i));
        }
        for(int i=0; i<words.length; i++){
            if(check(list,count,words[i])){
                result++;
            }
        }
        return result;
    }
    
    public boolean check(List<Character> list, List<Integer> count, String str){
        int idx = 0;
        char[] c =str.toCharArray();
        char before = c[0];
        int cnt = 1;
        for(int i=1; i<c.length; i++){
            if(before!=c[i]){
                if(list.get(idx)!=before || count.get(idx)<cnt || (count.get(idx)==2 && cnt==1)){
                    return false;
                }
                before = c[i];
                cnt=1;
                idx++;
                if(list.size()==idx){
                    return false;
                }
            }else{
                cnt++;
            }
        }
        if(list.get(idx)!=before || count.get(idx)<cnt || (count.get(idx)==2 && cnt==1)){
            return false;
        }
        return list.size()==idx+1;
    }
    
}