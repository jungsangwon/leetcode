class Solution {
    public int containVirus(int[][] isInfected) {
        // for(int i=0; i<isInfected.length; i++){
        //     for(int j=0; j<isInfected[i].length; j++){
        //         System.out.print(isInfected[i][j]);
        //     }
        //     System.out.println("");
        // }
        // System.out.println("===========");
        int result = 0;
        boolean[][] check = new boolean[isInfected.length][isInfected[0].length];
        int max = 0;
        int x = -1;
        int y = -1;
        for(int i=0; i<isInfected.length; i++){
            for(int j=0; j<isInfected[i].length; j++){
                if(!check[i][j] && isInfected[i][j]==1){
                    int[][] next = isInfected.clone();
                    boolean[][] visit = new boolean[isInfected.length][isInfected[0].length];
                    int nextInfected = getNextInfect(isInfected,i,j,visit,check);
                    // System.out.println(i+", "+j+" = "+nextInfected);
                    if(max<nextInfected){
                        max = nextInfected;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        if(max!=0){
            result += getWall(isInfected,x,y);
            boolean[][] visit = new boolean[isInfected.length][isInfected[0].length];
            for(int i=0; i<isInfected.length; i++){
                for(int j=0; j<isInfected[i].length; j++){
                    if(!visit[i][j] && isInfected[i][j]==1){
                        infect(isInfected,i,j,visit);
                    }
                }
            }
            result += containVirus(isInfected);
        }
        return result;
    }
    
    public void infect(int[][] isInfected, int x, int y, boolean[][] visit){
        if(visit[x][y]){
            return;
        }
        if(isInfected[x][y]==0){
            visit[x][y] = true;
            isInfected[x][y] = 1;
        }else if(isInfected[x][y]==1){
             visit[x][y] = true;
            if(x+1<isInfected.length){
                 infect(isInfected,x+1,y,visit);
            }
            if(y+1<isInfected[x].length){
                 infect(isInfected,x,y+1,visit);
            }
            if(x-1>=0){
               infect(isInfected,x-1,y,visit);
            }
            if(y-1>=0){
               infect(isInfected,x,y-1,visit);
            }
        }
    }
    
    public int getNextInfect(int[][] isInfected, int x, int y, boolean[][] visit, boolean[][] check){
        int result = 0;
        if(isInfected[x][y]==0&&!visit[x][y]){
            visit[x][y] = true;
            return 1;
        }else if(isInfected[x][y]==1 &&!check[x][y]){
            check[x][y] = true;
            if(x+1<isInfected.length){
                 result += getNextInfect(isInfected,x+1,y,visit,check);
            }
            if(y+1<isInfected[x].length){
                 result += getNextInfect(isInfected,x,y+1,visit,check);
            }
            if(x-1>=0){
               result += getNextInfect(isInfected,x-1,y,visit,check);
            }
            if(y-1>=0){
               result += getNextInfect(isInfected,x,y-1,visit,check);
            }
        }
        return result;
    }
    
    public int getWall(int[][] isInfected, int x, int y){
        int result = 0;
        if(isInfected[x][y]==0){
            return 1;
        }else if(isInfected[x][y]==1){
            isInfected[x][y] = 2;
            if(x+1<isInfected.length){
                 result += getWall(isInfected,x+1,y);
            }
            if(y+1<isInfected[x].length){
                 result += getWall(isInfected,x,y+1);
            }
            if(x-1>=0){
               result += getWall(isInfected,x-1,y);
            }
            if(y-1>=0){
               result += getWall(isInfected,x,y-1);
            }
        }
        return result;
    }
}