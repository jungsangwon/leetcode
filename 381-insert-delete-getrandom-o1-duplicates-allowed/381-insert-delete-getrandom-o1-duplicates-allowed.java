class RandomizedCollection {
    Random r;
    HashMap<Integer , HashSet<Integer>> map;
    ArrayList<Integer> list;

    public RandomizedCollection() {
        list= new ArrayList<>();
        map= new HashMap<>();
        r= new Random();
    }

    public boolean insert(int val) {
        list.add(val);
        if(map.containsKey(val)){

            HashSet<Integer>set = map.get(val);
            set.add(list.size()-1);

            return false;
        }else{
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size()-1);
            map.put(val , set);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int vidx = map.get(val).iterator().next(); 
            int lidx = list.size()-1;
            int lval = list.get(lidx);

            list.set(lidx , val);
            list.set(vidx, lval);

            list.remove(lidx);
            map.get(val).remove(vidx);

            if(map.get(val).size()==0){
                map.remove(val);
            }
            if(map.containsKey(lval)){
                map.get(lval).remove(lidx);
                map.get(lval).add(vidx);
            }
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        int idx= r.nextInt(list.size());
        return list.get(idx);
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */