class Solution {
    public String solveEquation(String equation) {
        String[] str = equation.split("=");
        int[] left = getNum(str[0]);
        int[] right = getNum(str[1]);
        if(left[0]==right[0] && left[1]==right[1]){
            return "Infinite solutions";
        }else if(left[0]==right[0] && left[1]!=right[1]){
            return "No solution";
        }else{
            int tmp = (right[1]-left[1]) / (left[0]-right[0]);
            return "x="+tmp;
        }
    }
    
    public int[] getNum(String str){
        int[] result = new int[2];
        boolean minus = false;
        int now = -1;
        for(int i=0 ; i<str.length(); i++){
            if(str.charAt(i)=='x'){
                if(now==-1){
                    now = 1;
                }
                if(minus){
                    result[0] -= now;
                }else{
                    result[0] += now;
                }
                now = 0;
            }else if(str.charAt(i)=='-'){
                if(now!=-1){
                    if(minus){
                        result[1] -= now;
                    }else{
                        result[1] += now;
                    }
                }
                now=-1;
                minus = true;
            }else if(str.charAt(i)=='+'){
                if(now!=-1){
                    if(minus){
                        result[1] -= now;
                    }else{
                        result[1] += now;
                    }
                }
                now=-1;
                minus = false;
            }else{
                if(now==-1){
                    now = str.charAt(i)-'0';
                }else{
                    now = now*10 + str.charAt(i)-'0';
                }
            }
        }
        if(minus){
            result[1] -= now;
        }else{
            result[1] += now;
        }
        System.out.println(result[0]+", "+result[1]);
        return result;
    }
}