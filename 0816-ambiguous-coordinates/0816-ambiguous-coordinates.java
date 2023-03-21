class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> list = new ArrayList<>();
        String tmp = s.substring(1,s.length()-1);
        for(int i=1;i<tmp.length();i++){
            String a = tmp.substring(0,i);
            String b = tmp.substring(i,tmp.length());
            for(int j=0; j<=a.length(); j++){
                String dotA = toDotFormat(a.substring(0,j),a.substring(j));
                if(dotA!=null){
                    for(int k=0; k<=b.length(); k++){
                        String dotB = toDotFormat(b.substring(0,k),b.substring(k));
                        if(dotB!=null){
                            list.add(toResultFormat(dotA,dotB));
                        }
                    }
                    
                }
            }
        }
            return list;
    }
    
    public String toDotFormat(String a, String b){
        if(a.length()==0){
            return null;
        }
        if(a.charAt(0)=='0'&&a.length()>1){
            return null;
        }
        if(b.length()==0){
            return a;
        }
        if(Integer.parseInt(b)==0){
            return null;
        }else if(b.charAt(b.length()-1)=='0'){
            return null;
        }
        return a+"."+b;
    }
    
    public String toResultFormat(String a, String b){
        return "("+a+", "+b+")";
    }
}