class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<len; i++){
            char tmp = s.charAt(i);
            if(tmp=='('||tmp=='{'||tmp=='['){
                st.push(tmp);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char base = st.pop();
                if(tmp==')'&&base!='('){
                    return false;
                }else if(tmp=='}'&&base!='{'){
                    return false;
                }else if(tmp==']'&&base!='['){
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}