class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s.toCharArray(),0,new LinkedList<>(), new HashMap<>());
    }
    
    public boolean checkValidString(char[] c, int idx, List<Character> list, HashMap<String,Boolean> dp) {
        String key = idx+","+list.size();
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        for(int i=idx; i<c.length; i++){
            if(c[i]==')'){
                if(list.isEmpty()){
                    return false;
                }else{
                    list.remove(list.size()-1);
                }
            }else if(c[i]=='('){
                list.add('(');
            }else{
                boolean result = false;
                List<Character> next = new LinkedList<>(list);
                if(!next.isEmpty()){
                    next.remove(list.size()-1);
                    result = result || checkValidString(c,i+1,next,dp);
                }
                if(result){
                    dp.put(key,result);
                    return result;
                }
                next = new LinkedList<>(list);
                next.add('(');
                result = result || checkValidString(c,i+1,next,dp);
                if(result){
                    dp.put(key,result);
                    return result;
                }
                result = result || checkValidString(c,i+1,list,dp);
                dp.put(key,result);
                return result;
            }
        }
        if(list.size()==0){
            dp.put(key,true);
            return true;
        }else{
            dp.put(key,false);
            return false;
        }
    }
}