class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project[] projects = new Project[profits.length];
        for(int i=0; i<profits.length; i++){
            projects[i] = new Project(profits[i],capital[i]);
        }
        
        Arrays.sort(projects,(Project a, Project b)->a.capital-b.capital);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i=0; i<k; i++){
            idx = canProject(w,projects,idx,pq);
            if(pq.isEmpty()){
                break;
            }
            int max = pq.poll();
            w+=max;
        }
        return w;
    }
    
    public int canProject(int w, Project[] projects, int idx, PriorityQueue<Integer> pq){
        while(idx<projects.length){
            if(projects[idx].capital>w){
                return idx;
            }else{
                pq.add(projects[idx].profit);
            }
            idx++;
        }
        return idx;
    }
}

class Project{
    int profit;
    int capital;
    public Project(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}