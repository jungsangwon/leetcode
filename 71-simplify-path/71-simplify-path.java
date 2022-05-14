class Solution {
    public String simplifyPath(String path) {
        String[] pathNode = path.split("/");
        StringBuilder result = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i=0; i<pathNode.length; i++){
            if(pathNode[i]!=null&&pathNode[i]!=""&&!pathNode[i].equals(".")){
                if(pathNode[i].equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }else{
                    st.push(pathNode[i]);
                }
            }
        }
        
        while(!st.isEmpty()){
            result.insert(0,st.pop());
            result.insert(0,"/");
        }
        if(result.length()==0){
            result.append("/");
        }
        
        return result.toString();
    }
}