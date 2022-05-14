class Solution {
    public String minWindow(String s, String t) {
        String result = null;
        char[] ct = t.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> key = new HashMap<>(); 
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        int lastIdx=0;
        for(int i=0; i<ct.length; i++){
            hm.put(ct[i],hm.getOrDefault(ct[i],0)+1);
        }
        for(int i=0;i<s.length(); i++){
            char tmp = s.charAt(i);
            if(hm.containsKey(tmp)){
                String str = getWindow(s,new HashMap<>(hm),key,i, qu);
                if(str!=null){
                    result = str;
                    lastIdx = i+str.length();
                }else{
                    return "";
                }
                break;
            }
        }
        if(result==null){
            return "";
        }
        
        // System.out.println(result+", "+lastIdx);
        while(!qu.isEmpty()){
            // System.out.println("qu : "+qu.toString());
            char tmp = s.charAt(qu.poll());
            // System.out.println("tmp : "+tmp);
            key.put(tmp,key.get(tmp)-1);
            // System.out.println("key -> "+key.get(tmp)+" hm -> "+hm.get(tmp));
            // System.out.println("lastIdx : "+lastIdx);
            if(key.get(tmp)>=hm.get(tmp)){
                String str = s.substring(qu.peek(),lastIdx);
                if(str.length()<result.length()){
                    result =str;
                }
                continue;
            }else{
                int check = -1;
                for(int i=lastIdx; i<s.length();i++){
                    if(tmp == s.charAt(i)){
                        String str = s.substring(qu.peek(),i+1);
                        check = 0;
                        qu.add(i);
                        lastIdx = i+1;
                        key.put(tmp,key.get(tmp)+1);
                        // System.out.println(tmp+"->"+str);
                        if(str.length()<result.length()){
                            result = str;
                        }
                        break;
                    }
                    
                    if(key.containsKey(s.charAt(i))){
                        qu.add(i);
                        key.put(s.charAt(i),key.get(s.charAt(i))+1);
                    }
                }
                if(check==-1){
                    break;
                }
            }
        }
        
        
        
        return result;
    }
    
    public String getWindow(String s, HashMap<Character,Integer> hm, HashMap<Character,Integer> key, int idx, PriorityQueue<Integer> qu){
        int lastidx = idx;
        for(int i=idx; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(key.containsKey(tmp)||hm.containsKey(tmp)){
                qu.add(i);
                key.put(tmp,key.getOrDefault(tmp,0)+1);
                if(hm.containsKey(tmp)){
                    int count = hm.get(tmp);
                    if(count==1){
                        hm.remove(tmp);
                        lastidx = i;
                        if(hm.keySet().size()==0){
                            break;
                        }
                    }else{
                        hm.put(tmp,count-1);
                    }
                }
            }
        }
        if(hm.keySet().size()!=0){
            return null;
        }else{
            return s.substring(idx,lastidx+1);
        }
    }
}