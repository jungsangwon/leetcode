class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] check = new int[dungeon.length][dungeon[0].length];
        int x=dungeon.length-1;
        int y=dungeon[0].length-1;
        int last = dungeon[x][y];
        if(last>=0){
            check[x][y] = 1;
        }else{
            check[x][y] = (-1 * last) + 1;
        }
        
        for(int i=x-1; i>=0; i--){
            int tmp = check[i+1][y]-dungeon[i][y];
            if(tmp<=0){
                tmp = 1;
            }
            check[i][y] = tmp;
        }
        
        for(int i=y-1; i>=0; i--){
            int tmp = check[x][i+1]-dungeon[x][i];
            if(tmp<=0){
                tmp = 1;
            }
            check[x][i] = tmp;
        }
        
        for(int i =x-1;i>=0;i--){
            for(int j=y-1;j>=0;j--){
                check[i][j] = Math.min(check[i+1][j],check[i][j+1]) - dungeon[i][j];
                if(check[i][j]<=0){
                    check[i][j] = 1;
                }
            }
        }
        
        return check[0][0];
    }
}