class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx<sx || ty<sy){
            return false;
        }else if((tx==sx && (ty-sy)%tx==0)||(ty==sy && (tx-sx)%ty==0)){
            return true;
        }else{
            if(tx>ty){
                return reachingPoints(sx,sy,tx%ty,ty);
            }else{
                return reachingPoints(sx,sy,tx,ty%tx);
            }
        }
    }
}