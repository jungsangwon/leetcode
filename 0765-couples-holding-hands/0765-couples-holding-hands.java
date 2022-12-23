class Solution {
    public int minSwapsCouples(int[] row) {
        int result = 0;
        HashMap<Integer,Couple> map = new HashMap<>();
        for(int i=0; i<row.length; i+=2){
            Couple c = new Couple(row[i],row[i+1]);
            map.put(row[i],c);
            map.put(row[i+1],c);
            int big = row[i];
            int small = row[i+1];
            if(row[i]<row[i+1]){
                big = row[i+1];
                small = row[i];
            }
            if(small%2==0 && small+1==big){
                c.visit = true;
            }
        }
        for(int i=0; i<row.length; i+=2){
            Couple now = map.get(row[i]);
            // System.out.println(row[i]+", "+row[i+1]+" : "+now.visit);
            if(!now.visit){
                int before = now.node[0];
                int count = 0;
                while(!now.visit){
                    // System.out.print(before+" -> ");
                    int next;
                    if(before%2==0){
                        next=before+1;
                    }else{
                        next=before-1;
                    }
                    now.visit = true;
                    now = map.get(next);
                    before = now.node[0]==next?now.node[1]:now.node[0];
                    count++;
                }
                // System.out.println("");
                result += (count-1);
                // System.out.println(count);
            }
        }
        
        return result;
    }
}

class Couple{
    int[] node = new int[2];
    boolean visit = false;
    Couple c;
    public Couple(int node1, int node2){
        node[0] = node1;
        node[1] = node2;
    }
}