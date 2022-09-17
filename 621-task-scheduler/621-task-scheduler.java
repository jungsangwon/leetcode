class Solution {
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        int check = 0;
        Queue<Task> qu = new LinkedList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((Task a, Task b)->b.count-a.count);
        Task[] list = new Task[26];
        for(int i=0; i<tasks.length; i++){
            if(list[tasks[i]-'A']==null){
                list[tasks[i]-'A'] = new Task(1,tasks[i]);
            }else{
                list[tasks[i]-'A'].count++;
            }
        }
        for(int i=0; i<26; i++){
            if(list[i]!=null){
                pq.add(list[i]);
            }
        }
        for(int i=0; i<n; i++){
            qu.add(null);
        }
        while(check!=0 || pq.size()!=0){
            result++;
            if(pq.size()!=0){
                Task t = pq.poll();
                if(t.count==1){
                    qu.add(null);
                }else{
                    t.count--;
                    qu.add(t);
                    check++;
                }
            }else{
                qu.add(null);
            }
            Task t = qu.poll();
            if(t!=null){
                pq.add(t);
                check--;
            }
        }
        
        return result;
    }
}

class Task{
    int count = 0;
    char c;
    public Task(int count, char c){
        this.count = count;
        this.c = c;
    }
}