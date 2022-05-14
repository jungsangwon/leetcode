class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()>=4 && s.length()<=12){
            getIpAddresses(s,0,0,new StringBuilder(),result);
        }
        return result;
    }
    
    public void getIpAddresses(String s, int idx, int count, StringBuilder now, List<String> result){
        if(count == 3){
            String tmp = s.substring(idx,s.length());
            if(tmp.length() ==1 || (tmp.charAt(0)!='0' && Integer.parseInt(tmp)<=255)){
                now.append(tmp);
                result.add(now.toString());
            }
        }else{
            int min = (s.length()-idx) - (3-count)*3;
            int max = (s.length()-idx) - (3-count);
            min = Math.max(min,1);
            max = Math.min(max,3);
            String tmp = s.substring(idx,idx+min-1);
            now.append(tmp);
            for(int i = min-1; i<max; i++){
                tmp += s.charAt(idx+i);
                if(tmp.length() ==1 || (tmp.charAt(0)!='0' && Integer.parseInt(tmp)<=255)){
                    now.append(s.charAt(idx+i));
                    now.append(".");
                    getIpAddresses(s,idx+i+1,count+1,new StringBuilder(now),result);
                    now.deleteCharAt(now.length()-1);
                }
            }
        }
    }
}