class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 0;
        boolean[] visit = new boolean[points.length];
        Arrays.sort(points, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    if(a[1]==b[1]){
                        return 0;
                    }else if(a[1]<b[1]){
                        return -1;
                    }else{
                        return 1;
                    }
                }else{
                    if(a[0]==b[0]){
                        return 0;
                    }else if(a[0]<b[0]){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
        });
        for(int i=0; i<points.length; i++){
            if(visit[i]){
                continue;
            }else{
                visit[i]=true;
                count++;
                int min = points[i][1];
                for(int j=i+1; j<points.length; j++){
                    if(points[j][0]<=min){
                        min = Math.min(min,points[j][1]);
                        visit[j] = true;
                    }else{
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}