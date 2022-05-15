class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder st = new StringBuilder();
        HashMap<Long,Integer> map = new HashMap<>();
        boolean minus = false;
        if(numerator==0){
            return "0";
        }
        long num = numerator;
        long den = denominator;
        if(numerator<0){
            num *= -1;
            minus = true;
        }
        if(denominator<0){
            den *= -1;
            minus = !minus;
        }
        long first = num/den;
        num = num%den;
        boolean point = false;
        if(num!=0){
            point = true;
        }
        int index = 0;
        while(num!=0){
            map.put(num,index++);
            num *= 10;
            long tmp = num/den;
            st.append(tmp);
            num = num%den;
            if(map.containsKey(num)){
                st.insert(map.get(num),"(");
                st.append(")");
                break;
            }
        }

        if(point){
            st.insert(0,".");
        }
        st.insert(0,first);
        if(minus){
            st.insert(0,"-");
        }
        return st.toString();
    }
}
