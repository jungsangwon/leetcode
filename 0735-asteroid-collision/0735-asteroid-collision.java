class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> now = new ArrayList<>();
        for(int i=0; i<asteroids.length; i++){
            now.add(asteroids[i]);
        }
        List<Integer> list = asteroidCollision(now);
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public List<Integer> asteroidCollision(List<Integer> list) {
        // for(int i : list){
        //     System.out.println(i);
        // }
        // System.out.println("=====");
        if(list.isEmpty()){
            return list;
        }
        List<Integer> next = new ArrayList<>();
        for(int i=1; i<list.size(); i++){
            if(list.get(i-1)>0 && list.get(i)<0){
                if(Math.abs(list.get(i-1))>Math.abs(list.get(i))){
                    next.add(list.get(i-1));
                }else if(Math.abs(list.get(i-1))<Math.abs(list.get(i))){
                    next.add(list.get(i));
                }
                i++;
            }else{
                next.add(list.get(i-1));
            }
        }
        if(list.size()<2 || !(list.get(list.size()-2)>0 && list.get(list.size()-1)<0)){
            next.add(list.get(list.size()-1));
        }
        if(next.size()==list.size()){
            return next;
        }else{
            return asteroidCollision(next);
        }
    }
}