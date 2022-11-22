class Solution {
    public int maxProfit(int[] prices, int fee) {
                
      int oldBuy=-prices[0];
      int oldSell=0;
      for(int i=1;i<prices.length;i++)
      {
          int buy=Math.max(oldBuy,oldSell-prices[i]);
          int sell=Math.max(oldSell,oldBuy+prices[i]-fee);
          oldBuy = buy;
          oldSell=sell;
      }
     
         return oldSell;
    }
}