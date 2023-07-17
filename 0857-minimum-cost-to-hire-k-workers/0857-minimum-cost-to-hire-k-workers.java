class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        TreeMap<Double,List<Worker>> map = new TreeMap<>();
        for(int i=0; i<quality.length; i++){
            Worker worker = new Worker(quality[i],wage[i]);
            List<Worker> list = map.getOrDefault(worker.rate,new ArrayList<>());
            list.add(worker);
            map.put(worker.rate,list);
        }
        double result = Double.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(double rate : map.keySet()){
            for(Worker worker : map.get(rate)){
                pq.add(worker.quality);
                sum += worker.quality;
            }
            while(pq.size()>k){
                sum -= pq.poll();
            }
            if(pq.size()==k){
                // System.out.println("rate : "+rate+", sum : "+sum+" = "+rate*sum);
                result = Math.min(result,rate*sum);
            }
        }
        
        return (double)Math.round(result*100000)/100000;
    }
}

class Worker{
    public int quality;
    public int wage;
    public double rate;
    
    public Worker(int quality, int wage){
        this.quality = quality;
        this.wage = wage;
        this.rate = wage;
        this.rate /= quality;
    }
}