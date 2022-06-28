class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        
        HashSet<String> points = new HashSet<>();
        
        for(int[] rec : rectangles){
            int x = rec[0];
            int y = rec[1];
            int a = rec[2];
            int b = rec[3];
            
            min_x = Math.min(min_x,x);
            min_y = Math.min(min_y,y);
            max_x = Math.max(max_x,a);
            max_y = Math.max(max_y,b);
            
            addPoint(points,getPoint(x,y));
            addPoint(points,getPoint(x,b));
            addPoint(points,getPoint(a,y));
            addPoint(points,getPoint(a,b));
            
            area += (a-x)*(b-y);
        }
        
        if(points.size()!=4 || !points.contains(getPoint(min_x,min_y)) || !points.contains(getPoint(min_x,max_y)) || !points.contains(getPoint(max_x,min_y)) || !points.contains(getPoint(max_x,max_y)) ){
            return false;
        }
        int fullArea = (max_x - min_x) * (max_y - min_y);
        return fullArea == area;
    }
    
    public void addPoint(HashSet<String> points, String point){
        if(points.contains(point)){
            points.remove(point);
        }else{
            points.add(point);
        }
    }
    
    public String getPoint(int a, int b){
        return a+","+b;
    }
//     public boolean isRectangleCover(int[][] rectangles) {
//         boolean result = true;
//         Arrays.sort(rectangles, new Comparator<>(){
//            @Override
//             public int compare(int[] a, int[] b){
//                 return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];
//             }
//         });
//         int max_x = rectangles[rectangles.length-1][2];
//         int max_y = Integer.MIN_VALUE;
        
//         HashSet<String> merge = new HashSet<>();
//         HashSet<String> start = new HashSet<>();
//         start.add(rectangles[0][0]+","+rectangles[0][1]);
        
//         for(int i=0;i<rectangles.length;i++){
//             if(rectangles[i][0]!=rectangles[0][0]){
//                 break;
//             }else{
//                 max_y = rectangles[i][3];
//             }
//         }
//         HashMap<Integer,Integer> idx = new HashMap<>();
        
//         for(int i=0;i<rectangles.length;i++){
//             String key = rectangles[i][0]+","+rectangles[i][1];
//             if(start.contains(key)){
//                 start.remove(key);
//                 String tmp = rectangles[i][2]+","+rectangles[i][3];
//                 if(merge.contains(tmp)){
//                     return false;
//                 }else{
//                     if(start.contains(tmp)){
//                         start.remove(tmp);
//                     }
//                     merge.add(tmp);
//                 }
//                 if(rectangles[i][2]<max_x){
//                     String key1 = rectangles[i][2]+","+rectangles[i][1];
//                     idx.put(rectangles[i][1],Math.max(idx.getOrDefault(rectangles[i][1],Integer.MIN_VALUE),rectangles[i][2]));
//                     if(!merge.contains(key1)){
//                         start.add(key1);
//                     }
//                 }else if(rectangles[i][2]>max_x){
//                     return false;
//                 }else{
//                     idx.put(rectangles[i][1],Math.max(idx.getOrDefault(rectangles[i][1],Integer.MIN_VALUE),rectangles[i][2]));
//                 }
//                 if(rectangles[i][3]<max_y){
//                     String key2 = rectangles[i][0]+","+rectangles[i][3];
//                     if(!idx.containsKey(rectangles[i][3]) || idx.get(rectangles[i][3])<=rectangles[i][0]){
//                         start.add(key2);
//                     }
//                 }else if(rectangles[i][3]>max_y){
//                     return false;
//                 }
//             }else{
//                 return false;
//             }
//         }
//         return start.size()==0;
//     }
}