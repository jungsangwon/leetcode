class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Target[] list = new Target[indices.length];
        for(int i=0; i<indices.length; i++){
            list[i] = new Target(indices[i],sources[i],targets[i]);
        }
        Arrays.sort(list,(a,b)->b.idx-a.idx);
        for(int i=0; i<list.length; i++){
            String tmp="";
            if(s.length()>=list[i].idx+list[i].source.length()){
                tmp = s.substring(list[i].idx,list[i].idx+list[i].source.length());
            }
            if(tmp.equals(list[i].source)){
                s = s.substring(0,list[i].idx)+list[i].target+s.substring(list[i].idx+list[i].source.length());
            }
        }
        
        return s;
    }
}

class Target{
    int idx;
    String source;
    String target;
    public Target(int idx, String source, String target){
        this.idx = idx;
        this.source = source;
        this.target = target;
    }
}