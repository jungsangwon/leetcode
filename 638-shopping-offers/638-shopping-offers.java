class Solution {
    private HashMap<String,Integer> dp = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        StringBuilder key = new StringBuilder();
        for(int num : needs){
            key.append(num);
            key.append(",");
        }
        if(dp.containsKey(key.toString())){
            return dp.get(key.toString());
        }
        int result = 0;
        for(int i=0; i<needs.size(); i++){
            result += (price.get(i) * needs.get(i));
        }
        for(List<Integer> list : special){
            boolean check = true;
            for(int i=0; i<needs.size();i++){
                if(needs.get(i)<list.get(i)){
                    check = false;
                    break;
                }
            }
            if(check){
                for(int i=0; i<needs.size();i++){
                    needs.set(i,needs.get(i)-list.get(i));
                }
                result = Math.min(result,shoppingOffers(price,special,needs)+list.get(needs.size()));
                for(int i=0; i<needs.size();i++){
                    needs.set(i,needs.get(i)+list.get(i));
                }
            }
        }
        dp.put(key.toString(),result);
        return result;
    }
}