class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        boolean left = false;
        int max = 0;
        if(ver1.length>ver2.length){
            max = ver2.length;
        }else{
            max = ver1.length;
            left = true;
        }
        for(int i=0; i<max; i++){
            int num1 = Integer.parseInt(ver1[i]);
            int num2 = Integer.parseInt(ver2[i]);
            if(num1<num2){
                return -1;
            }else if(num1>num2){
                return 1;
            }
        }
        if(!left){
            for(int i = max; i<ver1.length; i++){
                int tmp = Integer.parseInt(ver1[i]);
                if(tmp!=0){
                    return 1;
                }
            }
        }else{
            for(int i = max; i<ver2.length; i++){
                int tmp = Integer.parseInt(ver2[i]);
                if(tmp!=0){
                    return -1;
                }
            }
        }
        return 0;
    }
}