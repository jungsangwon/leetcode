class Solution {
    public int numRabbits(int[] answers) {
        int result = 0;
        HashMap<Integer,Integer> check = new HashMap<>();
        for(int i=0; i<answers.length; i++){
            int count = check.getOrDefault(answers[i],0);
            if(count==0){
                check.put(answers[i],answers[i]);
                result+=(answers[i]+1);
            }else{
                check.put(answers[i],count-1);
            }
        }
        return result;
    }
}