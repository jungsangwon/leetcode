class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        Arrays.sort(worker);
        Work[] list = new Work[difficulty.length];
        for(int i=0; i<difficulty.length; i++){
            list[i] = new Work(difficulty[i],profit[i]);
        }
        
        Arrays.sort(list,(a, b)->a.difficulty-b.difficulty);
        int max = 0;
        for(int i=0; i<list.length; i++){
            max = Math.max(max,list[i].profit);
            list[i].profit = max;
        }
        
        int from = 0;
        int to = list.length-1;
        for(int i=0; i<worker.length; i++){
            int tmp = getWork(list,worker[i],from,to);
            if(tmp!=-1){
                // System.out.println(worker[i] +" : "+list[tmp].profit);
                result += list[tmp].profit;
                from = tmp;
            }
        }
        
        return result;
    }
    
    public int getWork(Work[] list, int target, int from, int to){
        while(from<=to){
            int mid = (from+to)/2;
            if(list[mid].difficulty == target){
                while(mid+1<=to && list[mid+1].difficulty == target){
                    mid++;
                }
                return mid;
            }else if(list[mid].difficulty < target){
                from = mid+1;
            }else{
                to = mid-1;
            }
        }
        return from-1;
    }
}

class Work{
    int difficulty = 0;
    int profit = 0;
    public Work(int difficulty, int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}