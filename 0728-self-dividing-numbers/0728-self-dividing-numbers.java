class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left; i<=right; i++){
            int tmp = i;
            boolean check = true;
            while(tmp!=0){
                if((tmp%10)==0 || i%(tmp%10)!=0){
                    check=false;
                    break;
                }
                tmp/=10;
            }
            if(check){
                result.add(i);
            }
        }
        return result;
    }
}