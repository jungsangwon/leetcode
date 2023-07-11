class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for(int i=0; i<position.length; i++){
            list.add(new Car(position[i],speed[i]));
        }
        Collections.sort(list,(a,b)->b.position-a.position);
        
        return carFleet(target,list);
    }
    
    public int carFleet(int target, List<Car> list){
        // for(Car c : list){
        //     System.out.println(c.position+" : "+c.speed);
        // }
        // System.out.println("===========");
        if(list.size()<=1){
            return list.size();
        }else{
            int result = 0;
            Double max = 0D;
            List<Car> next = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                Car now = list.get(i);
                int nextP = now.position+now.speed;
                if(next.isEmpty()){
                    if(nextP>=target){
                        double time = (double)(target-now.position)/now.speed;
                        // System.out.println(time+" : "+max);
                        if(time>max){
                            result++;
                            max = time;
                        }
                    }else{
                        next.add(new Car(nextP,now.speed));
                    }
                }else{
                    Car last = next.get(next.size()-1);
                    if(last.position>nextP){
                        next.add(new Car(nextP,now.speed));
                    }
                }
            }
            return result + carFleet(target,next);
        }
    }
}

class Car{
    int position;
    int speed;
    
    public Car(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}