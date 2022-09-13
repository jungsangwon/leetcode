class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i=0; i<list1.length; i++){
            for(int j=0; j<list2.length; j++){
                if(i+j>min){
                    break;
                }
                if(list1[i].equals(list2[j])){
                    if(min > i+j){
                        min = i+j;
                        list = new ArrayList<>();
                    }
                    list.add(list1[i]);
                }
            }
        }
        String[] result = new String[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}