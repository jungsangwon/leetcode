class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        if(points.length<=1){
            return points.length;
        }
        HashMap<String, HashSet<Point>> map = new HashMap<>();
        List<Point> list = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            list.add(new Point(points[i][0],points[i][1]));
        }
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size();j++){
                String key = getKey(list.get(i),list.get(j));
                // System.out.println("["+list.get(i).x+","+list.get(i).y+"]["+list.get(j).x+","+list.get(j).y+"] = "+key);
                HashSet<Point> hashSet = map.getOrDefault(key,new HashSet<>());
                hashSet.add(list.get(i));
                hashSet.add(list.get(j));
                map.put(key,hashSet);
            }
        }
        
        for(String key : map.keySet()){
            HashSet<Point> hashSet = map.get(key);
            if(max<hashSet.size()){
                max = hashSet.size();
            }
        }
        
        return max;
    }
    
    public String getKey(Point point1, Point point2){
        StringBuilder st = new StringBuilder();
        int a = point1.x - point2.x;
        int b = point1.y - point2.y;
        if(a==0){
            st.append("x=");
            st.append(point1.x);
        }else if(b==0){
            st.append("y=");
            st.append(point1.y);
        }else{
            boolean minus = false;
            if(a*b<0){
                minus = true;
            }
            a=Math.abs(a);
            b=Math.abs(b);
            int gcd = GCD(a,b);
            a=a/gcd;
            b=b/gcd;
            st.append("y=");
            if(minus){
                st.append("-");
            }
            st.append(b);
            st.append("/");
            st.append(a);
            st.append("x");
            if(minus){
                b = b*-1;
            }
            int tmp1 = (a * point1.y) - (b * point1.x);
            int tmp2 = a;
            if(tmp1 == 0){
                st.append(tmp1);
                return st.toString();
            }
            minus = false;
            if(tmp1*tmp2<0){
                minus = true;
            }
            tmp1=Math.abs(tmp1);
            tmp2=Math.abs(tmp2);
            gcd = GCD(tmp1,tmp2);
            tmp1=tmp1/gcd;
            tmp2=tmp2/gcd;
            if(minus){
                st.append("-");
            }else{
                st.append("+");
            }
            st.append(tmp1);
            st.append("/");
            st.append(tmp2);
        }
        return st.toString();
    }
    
    public int GCD(int a, int b){
        if(b > a){
            int temp = b;
            b = a;
            a = temp;
        }

        if(a%b == 0){
            return b;
        }
        return GCD(b, a%b);

    }
}

class Point{
    int x = 0;
    int y = 0;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}