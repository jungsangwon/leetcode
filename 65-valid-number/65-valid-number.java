class Solution {
    public boolean isNumber(String s) {
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            s = s.substring(1,s.length());
        }
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            return false;
        }
        String[] tmp;
        int e = s.indexOf("e");
        int e1 = s.indexOf("E");
        if(e==1&&e1==1){
            return false;
        }else if(e==-1&&e1==-1){
            if(s.indexOf(".")==-1){
                if(!isNum(s)){
                    return false;
                }
            }else{
                if(!isDecimal(s)){
                    return false;
                }else{
                    return true;
                }
            }
            
        }else{
            if(e != -1){
                if(s.indexOf("e")!=s.lastIndexOf("e")){
                    return false;
                }
                tmp = s.split("e");
            }else{
                if(s.indexOf("E")!=s.lastIndexOf("E")){
                    return false;
                }
                tmp = s.split("E");
            }
            if(tmp.length != 2){
                return false;
            }
            if(tmp[1].indexOf(".")!=-1){
                return false;
            }
            if(tmp[0].indexOf(".")!=-1){
                if(!isDecimal(tmp[0])){
                    return false;
                }
                if(!isNum(tmp[1])){
                    return false;
                }
            }else{
                if(!isNum(tmp)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isDecimal(String s){
        if(s.indexOf(".")!=s.lastIndexOf(".")){
            return false;
        }
        String[] tmp = s.split("\\.");
        if(tmp.length == 2){
            if(tmp[0].equals("")){
                tmp[0] = "0";
            }
            if(tmp[1].indexOf("+")!=-1||tmp[1].indexOf("-")!=-1){
                return false;
            }
        }else if(tmp.length == 1){
            if(tmp[0].equals("")){
                tmp[0] = "0";
            }
        }else{
            return false;
        }
        return isNum(tmp);
    }
    
    public boolean isNum(String[] tmp){
        for(int i=0; i<tmp.length; i++){
            if(!isNum(tmp[i])){
                return false;
            }
        }
        return true;
    }
    
    public boolean isNum(String s){
        try{
            System.out.println(s);
            Long.parseLong(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}