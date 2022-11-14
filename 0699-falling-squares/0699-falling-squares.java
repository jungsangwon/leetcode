class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        List<Square> list = new ArrayList<>();
        result.add(positions[0][1]);
        list.add(new Square(positions[0][0],0,positions[0][1]));
        
        for(int i=1; i<positions.length; i++){
            int max = 0;
            for(Square s : list){
                if(isCheck(s,positions[i])){
                    max = Math.max(max,s.y[1]);
                }
            }
            list.add(new Square(positions[i][0],max,positions[i][1]));
            result.add(Math.max(result.get(result.size()-1),max+positions[i][1]));
        }
        
        return result;
    }
    
    public boolean isCheck(Square s, int[] positions){
        int tmp = positions[0]+positions[1];
        return (s.x[0]<=positions[0] && s.x[1]>positions[0]) || (s.x[0]<tmp && s.x[1]>=tmp) || (positions[0]<=s.x[0] && s.x[1]<=tmp);
    }
    
    public int getIdx(List<Square> list, int[] positions){
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = (left+right) / 2;
            Square tmp = list.get(mid);
            if(tmp.x[0]<positions[0]){
                left = mid + 1;
            }else if(tmp.x[0]>positions[0]){
                right = mid - 1;
            }else{
                if(tmp.x[1]<=positions[0]+positions[1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return left;
    }
}

class Square{
    int[] x = new int[2];
    int[] y = new int[2];
    public Square(int x, int y, int len){
        this.x[0] = x;
        this.y[0] = y;
        this.x[1] = x + len;
        this.y[1] = y + len;
    }
    
    public String toString(){
        return x[0]+"~"+x[1]+"/"+y[0]+"~"+y[1];
    }
}