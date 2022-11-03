class Solution {
    public boolean judgePoint24(int[] cards) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<4; i++){
            int[] tmp = new int[2];
            tmp[0] = cards[i];
            tmp[1] = 1;
            list.add(tmp);
        }
        return judgePoint24(list);
    }
    
    public boolean judgePoint24(List<int[]> list) {
        if(list.size() == 1){
            int[] now = list.get(0);
            if(now[0]==24 && now[1] == 1){
                return true;
            }else{
                return false;
            }
        }
        boolean result = false;
        int size = list.size();
        for(int i=0; i<size-1; i++){
            int[] num1 = list.get(i);
            for(int j=i+1; j<size;j++){
                int[] num2 = list.get(j);
                List<int[]> nextList =calculate(num1,num2);
                for(int[] tmp : nextList){
                    List<int[]> next = new ArrayList<>(list);
                    next.remove(j);
                    next.remove(i);
                    next.add(tmp);
                    result = judgePoint24(next);
                    if(result){
                        return result;
                    }
                }
            }
        }
        return result;
    }
    
    public List<int[]> calculate(int[] n1, int[] n2){
        List<int[]> result = new ArrayList<>();
        HashSet<String> dp = new HashSet<>();
        int[] num1 = n1.clone();
        int[] num2 = n2.clone();
        int gcd = gcd(Math.max(num1[1],num2[1]),Math.min(num1[1],num2[1]));
        for(int i=0; i<2; i++){
            num1[i] *= (n2[1]/gcd);
            num2[i] *= (n1[1]/gcd);
        }
        int[] plus = new int[2];
        plus[0] = num1[0]+num2[0];
        plus[1] = num1[1];
        try{
            min(plus);
            if(!dp.contains(getKey(plus))){
                dp.add(getKey(plus));
                result.add(plus);
            }
        }catch(Exception e){
        }
        
        int[] mutiply = new int[2];
        mutiply[1] = num1[1]*num2[1];
        mutiply[0] = num1[0]*num2[0];
        try{
            min(mutiply);
            if(!dp.contains(getKey(mutiply))){
                dp.add(getKey(mutiply));
                result.add(mutiply);
            }
        }catch(Exception e){
        }
        
        int[] divide = new int[2];
        divide[1] = num1[1]*num2[0];
        divide[0] = num1[0]*num2[1];
        try{
            min(divide);
            if(!dp.contains(getKey(divide))){
                dp.add(getKey(divide));
                result.add(divide);
            }
        }catch(Exception e){
        }
        divide = new int[2];
        divide[1] = num1[0]*num2[1];
        divide[0] = num1[1]*num2[0];
        try{
            min(divide);
            if(!dp.contains(getKey(divide))){
                dp.add(getKey(divide));
                result.add(divide);
            }
        }catch(Exception e){
        }
        
        int[] minus = new int[2];
        minus[0] = num1[0]-num2[0];
        minus[1] = num1[1];
        try{
            min(minus);
            if(!dp.contains(getKey(minus))){
                dp.add(getKey(minus));
                result.add(minus);
            }
        }catch(Exception e){
        }
        minus = new int[2];
        minus[0] = num2[0]-num1[0];
        minus[1] = num1[1];
        try{
            min(minus);
            if(!dp.contains(getKey(minus))){
                dp.add(getKey(minus));
                result.add(minus);
            }
        }catch(Exception e){
        }
        return result;
    }
    
    public String getKey(int[] num){
        return num[0]+"/"+num[1];
    }
    
    public void min(int[] num){
        int gcd = gcd(Math.max(num[0],num[1]),Math.min(num[0],num[1]));
        num[0] /= gcd;
        num[1] /= gcd;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
