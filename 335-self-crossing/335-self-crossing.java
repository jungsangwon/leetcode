class Solution {
    class Line{
        int from_x;
        int to_x;
        int from_y;
        int to_y;
        boolean direction = true;
        public Line(int from_x, int from_y, int to_x, int to_y){
            if(from_x == to_x){
                direction = true;
            }else{
                direction = false;
            }
            if(direction){
                this.from_x = from_x;
                this.to_x = to_x;
                 if(from_y<to_y){
                    this.from_y = from_y;
                    this.to_y = to_y;
                }else{
                    this.from_y = to_y;
                    this.to_y = from_y;
                }
            }else{
                this.from_y = from_y;
                this.to_y = to_y;
                if(from_x<to_x){
                    this.from_x = from_x;
                    this.to_x = to_x;
                }else{
                    this.from_x = to_x;
                    this.to_x = from_x;
                }
            }
        }
        public boolean isCross(Line l, boolean check){
             if(check){
                return (this.from_y<=l.from_y&&this.to_y>=l.from_y) || (this.from_y<=l.to_y&&this.to_y>=l.to_y) || (l.from_y<=this.from_y&&l.to_y>=this.to_y);
            }else{
                return (this.from_x<=l.from_x&&this.to_x>=l.from_x) || (this.from_x<=l.to_x&&this.to_x>=l.to_x) || (l.from_x<=this.from_x&&l.to_x>=this.to_x);
            }
        }
        public void print(){
            System.out.println(from_x+","+from_y+" -> "+to_x+","+to_y);
        }
    }
    public boolean isSelfCrossing(int[] distance) {
        if(distance.length<4){
            return false;
        }
        int before = distance[1];
        boolean check = false;
        if(distance[0] > distance[1]){
            check = true;
            for(int i=2 ;i<distance.length-1; i++){
                if(distance[i-1]<=distance[i]){
                    check = false;
                    break;
                }
            }
        }else if(distance[0] < distance[1]){
            check = true;
            for(int i=2 ;i<distance.length-1; i++){
                if(distance[i-1]>=distance[i]){
                    check = false;
                    break;
                }
            }
        }
        if(check){
            return false;
        }
        int x = 0;
        int y = 0;
        int[] x_distance = {0,-1,0,1};
        int[] y_distance = {1,0,-1,0};
        int now = 0;
        Map<Integer,List<Line>> x_map = new HashMap<>();
        Map<Integer,List<Line>> y_map = new HashMap<>();
        for(int i=0 ;i<distance.length; i++){
            int to_x =x+(distance[i]*x_distance[now]);
            int to_y =y+(distance[i]*y_distance[now]);
            Line line = new Line(x,y,to_x, to_y);
            if(line.direction){
                if(x_map.containsKey(x)){
                    for(Line l : x_map.get(x)){
                        if(l.isCross(line,true)){
                            return true;
                        }
                    }
                }
                for(int j=line.from_y+1; j<line.to_y; j++){
                    if(!y_map.containsKey(j)){
                        continue;
                    }
                    for(Line l : y_map.get(j)){
                        if(l.isCross(line,false)){
                            return true;
                        }
                    }
                }
                if(y_map.containsKey(to_y)){
                    for(Line l : y_map.get(to_y)){
                        if(l.isCross(line,false)){
                            return true;
                        }
                    }
                }
            }else{
                if(y_map.containsKey(y)){
                    for(Line l : y_map.get(y)){
                        if(l.isCross(line,false)){
                            return true;
                        }
                    }
                }
                for(int j=line.from_x+1; j<line.to_x; j++){
                    if(!x_map.containsKey(j)){
                        continue;
                    }
                    for(Line l : x_map.get(j)){
                        if(l.isCross(line,true)){
                            return true;
                        }
                    }
                }
                if(x_map.containsKey(to_x)){
                    for(Line l : x_map.get(to_x)){
                        if(l.isCross(line,true)){
                            return true;
                        }
                    }
                }
            }
            if(line.direction){
                List<Line> list = x_map.getOrDefault(x,new ArrayList<>());
                list.add(line);
                x_map.put(x,list);
            }else{
                List<Line> list = y_map.getOrDefault(y,new ArrayList<>());
                list.add(line);
                y_map.put(y,list);
            }
            x=to_x;
            y=to_y;
            now = (now+1)%4;
        }
        return false;
    }
}
