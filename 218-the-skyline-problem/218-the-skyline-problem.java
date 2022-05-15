class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result1 = getleftResult(buildings);
        List<List<Integer>> result2 = getRightResult(buildings);
        int idx1 = 0;
        int idx2 = result2.size()-1;
        while(result1.size()!=idx1&&idx2!=-1){
            List<Integer> tmp1 = result1.get(idx1);
            List<Integer> tmp2 = result2.get(idx2);
            if(tmp1.get(0)<tmp2.get(0)){
                result.add(tmp1);
                idx1++;
            }else{
                result.add(tmp2);
                idx2--;
            }
        }
        while(result1.size()!=idx1){
            result.add(result1.get(idx1));
            idx1++;
        }
        while(idx2!=-1){
            result.add(result2.get(idx2));
            idx2--;
        }
        
        return result;
    }
    
    public List<List<Integer>> getRightResult(int[][] buildings){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> idx = new PriorityQueue<>(Collections.reverseOrder());
        
        Arrays.sort(buildings, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        for(int i=buildings.length-1; i>=0; i--){
            int from = buildings[i][0];
            int to = buildings[i][1];
            int height = buildings[i][2];
            int now = 0;
            
            // System.out.println("===========");
            // System.out.println(from+" -> "+to+" : "+height);
            // PriorityQueue<Integer> tmp = new PriorityQueue<>(idx);
            // while(!tmp.isEmpty()){
            //     int p = tmp.poll();
            //     System.out.println(p+" : "+map.get(p));
            // }
                
            
            while(!idx.isEmpty()&& to<idx.peek()){
                idx.poll();
            }
            if(!idx.isEmpty()){
                now = map.get(idx.peek());
            }
            if(now<height){
                if(result.size()!=0 && to == result.get(result.size()-1).get(0)){
                    if(height<result.get(result.size()-1).get(1)){
                        result.remove(result.size()-1);
                        result.add(getResult(to,now));
                    }
                }else{
                    result.add(getResult(to,now));
                }
            }
            Queue<Integer> qu = new LinkedList<>();
            while(!idx.isEmpty()&&idx.peek()>from){
                int x = idx.poll();
                if(map.get(x)>height){
                    qu.add(x);
                }
            }
            if(idx.isEmpty() || map.get(idx.peek())<height){
                if(idx.isEmpty() || idx.peek() != from){
                    idx.add(from);
                }
                map.put(from,height);
            }
            while(!qu.isEmpty()){
                idx.add(qu.poll());
            }
        }
        return result;
    }
    
    public List<List<Integer>> getleftResult(int[][] buildings){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> idx = new PriorityQueue<>();
        
        Arrays.sort(buildings, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0; i<buildings.length; i++){
            int from = buildings[i][0];
            int to = buildings[i][1];
            int height = buildings[i][2];
            int now = 0;
            
            // System.out.println("===========");
            // System.out.println(from+" -> "+to+" : "+height);
            // PriorityQueue<Integer> tmp = new PriorityQueue<>(idx);
            // while(!tmp.isEmpty()){
            //     int p = tmp.poll();
            //     System.out.println(p+" : "+map.get(p));
            // }
                
            
            while(!idx.isEmpty()&& from>idx.peek()){
                idx.poll();
            }
            if(!idx.isEmpty()){
                now = map.get(idx.peek());
            }
            if(now<height){
                if(result.size()!=0 && from == result.get(result.size()-1).get(0)){
                    if(height>result.get(result.size()-1).get(1)){
                        result.remove(result.size()-1);
                        result.add(getResult(from,height));
                    }
                }else{
                    result.add(getResult(from,height));
                }
            }
            Queue<Integer> qu = new LinkedList<>();
            while(!idx.isEmpty()&&idx.peek()<to){
                int x = idx.poll();
                if(map.get(x)>height){
                    qu.add(x);
                }
            }
            if(idx.isEmpty() || map.get(idx.peek())<height){
                if(idx.isEmpty() || idx.peek() != to){
                    idx.add(to);
                }
                map.put(to,height);
            }
            while(!qu.isEmpty()){
                idx.add(qu.poll());
            }
        }
        return result;
    }
    
    public List<Integer> getResult(int x, int height){
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(height);
        return list;
    }
}