class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];
        int idx1=0,idx2=0;
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        for(int i=num1.length()-1; i>=0; i--){
            idx2=0;
            for(int j=num2.length()-1; j>=0; j--){
                int tmp = result[idx1+idx2];
                tmp += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                result[idx1+idx2] = tmp%10;
                result[idx1+idx2+1] += tmp/10;
                idx2++;
                // for(int k=result.length-1; k>=0; k--){
                //     System.out.print(result[k]);
                // }
                // System.out.println("");
            }
            idx1++;
        }
        StringBuilder st = new StringBuilder();
        int idx = result.length-1;
        for(; idx>=0; idx--){
            if(result[idx]!=0){
                break;
            }
        }
        for(int i=idx; i>=0; i--){
            st.append(result[i]);
        }
        return st.toString();
    }
}