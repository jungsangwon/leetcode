class Solution {
    public int lengthLongestPath(String input) {
        String[] str = input.split("\\n");
        Directory root = new Directory("");
        for(int i=0;i<str.length;i++){
            int count = getTabCount(str[i]);
            Directory now = root;
            for(int j=0; j<count; j++){
                now = now.getDirectory();
            }
            if(str[i].contains(".")){
                now.file.add(str[i].substring(count));
            }else{
                now.child.add(new Directory(str[i].substring(count)));
            }
        }
        return Math.max(0,lengthLongestPath(root)-1);
    }
    
    public int lengthLongestPath(Directory root) {
        // System.out.println(root.dir);
        int result = 0;
        for(Directory d : root.child){
            int t = lengthLongestPath(d);
            if(t!=0){
                result = Math.max(result,root.dir.length()+1+t);
            }
        }
        for(String f : root.file){
            result = Math.max(result,root.dir.length()+1+f.length());
        }
        return result;
    }
    
    public int getTabCount(String str){
        // System.out.println("str : "+str);
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.substring(i,i+1).equals("\t")){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

class Directory {
    String dir;
    List<Directory> child;
    List<String> file;
    public Directory(String dir){
        this.dir = dir;
        child = new ArrayList<>();
        file = new ArrayList<>();
    }
    public Directory getDirectory(){
        return child.get(child.size()-1);
    }
}