class Solution {
public String nearestPalindromic(String n) {
    // find the middle point of n
    int mid = n.length()/2;
    // convert n to long
    long curr = Long.parseLong(n);
    // set the anw to be 9999...{(n.length()-1) 9's}, incase someString like"10""100""1000"
    long anw=(long)Math.pow(10,(n.length()-1))-1;
    // get the left part of the Palindrome, even and odd are different
    String half = n.substring(0,mid);
    if(n.length()%2!=0){

            half = n.substring(0,mid+1);

        }
        // make the half plus 1, keep same and minus 1, use this as the reference to create Palindrome
        for(int a=-1; a<2;a++){

            long Half = Long.parseLong(half)+a; 
            long num = findPalindrome(String.valueOf(Half),mid,n,half);
            // pass n itself if it's a Palindrome
            if(num!=curr){

                if(Math.abs(num-curr)==Math.abs(anw-curr)){anw = Math.min(num,anw);}
                else if(Math.abs(num-curr)<Math.abs(anw-curr)){anw = num;}
            }

        }

        return String.valueOf(anw);
    }

    private long findPalindrome(String Half,int mid,String n, String half){
        StringBuilder sb = new StringBuilder();
        sb.append(Half);
        // set the middle point of the Palindrome
        int end = sb.length()-1;
        // if new half become longer than old half, move middle point forward
        if(Half.length()>half.length()){
            end--;
        }
        if(n.length()%2==1){end--;}

        for(int j=end; j>=0; j--){
            sb.append(sb.charAt(j));
        }
        return Long.parseLong(sb.toString());

    }
}