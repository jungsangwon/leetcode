class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        boolean[] check = new boolean[26];
        int start = 0;
        int sum = 0;
        for(int i=0; i<s1.length(); i++){
            int now = s1.charAt(i)-'a';
            count[now]++;
            check[now] = true;
            sum++;
        }
        for(int i=0; i<s2.length(); i++){
            int now = s2.charAt(i)-'a';
            // System.out.println(s2.charAt(i)+" : "+sum);
            if(!check[now]){
                while(start<=i){
                    int tmp = s2.charAt(start)-'a';
                    if(check[tmp]){
                        count[tmp]++;
                        sum++;
                    }
                    start++;
                }
            }else{
                if(count[now]>0){
                    count[now]--;
                    sum--;
                    if(sum==0){
                        return true;
                    }
                }else{
                     while(start<i){
                        int tmp = s2.charAt(start)-'a';
                        if(s2.charAt(i)==s2.charAt(start)){
                            start++;
                            break;
                        }else{
                            count[tmp]++;
                            sum++;
                            start++;
                        }
                    }
                }
            }
        }
        return false;
    }
}