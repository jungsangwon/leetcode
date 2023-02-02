class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        Queue<Glass> qu = new LinkedList<>();
        Glass last = new Glass(0,0,Double.valueOf(poured));
        qu.add(last);
        while(!qu.isEmpty()){
            Glass glass = qu.poll();
            if(glass.x==query_row && glass.y==query_glass){
                if(glass.sum>=1D){
                    return 1D;
                }else{
                    return glass.sum;
                }
            }else if(glass.x>=query_row && glass.y>query_glass){
                break;
            }
            if(glass.sum>1D){
                if(last.x==glass.x+1 && last.y==glass.y){
                    last.sum += (glass.sum-1)/2;
                }else{
                    last = new Glass(glass.x+1,glass.y,(glass.sum-1)/2);
                    qu.add(last);
                }
                last = new Glass(glass.x+1,glass.y+1,(glass.sum-1)/2);
                qu.add(last);
            }
            
        }
        return 0D;
    }
}

class Glass{
    int x;
    int y;
    double sum;
    public Glass(int x, int y, double sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}