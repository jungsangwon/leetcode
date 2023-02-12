class Solution {
    int result = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,Node> map = new HashMap<>();
        HashMap<Node,TreeMap<Integer,Integer>> visit = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i,new Node(i));
        }
        for(int i=0; i<flights.length; i++){
            Node from = map.get(flights[i][0]);
            Node to = map.get(flights[i][1]);
            from.addFlight(to,flights[i][2]);
        }
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        tmap.put(k,0);
        visit.put(map.get(src),tmap);
        findCheapestPrice(map.get(src),map.get(dst),k,0, visit);
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        return result;
    }
    
    public void findCheapestPrice(Node from, Node target, int k, int now, HashMap<Node,TreeMap<Integer,Integer>> visit){
        if(now<result){
            if(from == target){
                result = Math.min(result, now);
            }
            if(k>=0){
                for(Node next : from.flight.keySet()){
                    int nextNum = now+from.flight.get(next);
                    if(visit.containsKey(next)){
                        boolean check = true;
                        TreeMap<Integer,Integer> tmap = visit.get(next);
                        for(int last : tmap.keySet()){
                            if(last<k){
                                continue;
                            }else if(last==k){
                                if(tmap.get(last)<=nextNum){
                                    check = false;
                                    break;
                                }
                            }else{
                                if(tmap.get(last)<=nextNum){
                                    check = false;
                                }
                                break;
                            }
                        }
                        if(!check){
                            continue;
                        }
                    }
                    TreeMap<Integer,Integer> tmap = visit.getOrDefault(next,new TreeMap<>());
                    tmap.put(k,nextNum);
                    visit.put(next,tmap);
                    findCheapestPrice(next,target,k-1,nextNum,visit);
                }
            }
        }
    }
}

class Node{
    int now;
    HashMap<Node,Integer> flight;
    public Node(int now){
        this.now = now;
        flight = new HashMap<>();
    }
    
    public void addFlight(Node a, int num){
        flight.put(a,num);
    }
}