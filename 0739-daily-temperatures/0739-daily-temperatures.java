class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Day> st = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            Day now = new Day(i,temperatures[i]);
            while(!st.isEmpty()&&st.peek().temperature<now.temperature){
                Day before = st.pop();
                result[before.idx] = now.idx - before.idx;
            }
            st.push(now);
        }
        return result;
    }
}

class Day{
    int idx;
    int temperature;
    public Day(int idx, int temperature){
        this.idx = idx;
        this.temperature = temperature;
    }
}