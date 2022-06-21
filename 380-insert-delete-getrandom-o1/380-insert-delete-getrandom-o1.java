class RandomizedSet {
    HashSet<Integer> hashSet;
    
    public RandomizedSet() {
        hashSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        boolean result = hashSet.contains(val);
        if(!result){
            hashSet.add(val);
        }
        return !result;
    }
    
    public boolean remove(int val) {
        boolean result = hashSet.contains(val);
        if(result){
            hashSet.remove(val);
        }
        return result;
    }
    
    public int getRandom() {
        List<Integer> list = new ArrayList<>(hashSet);
        return list.get((int)(Math.floor(Math.random()*100000))%hashSet.size());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */