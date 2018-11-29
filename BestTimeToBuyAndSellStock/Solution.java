class Solution {
    public int maxProfit(int[] prices) {
      int minPrice = Integer.MAX_VALUE;
      int res = 0;
      for(int price : prices){
        if(price < minPrice)
          minPrice = price;
        else if(price-minPrice > res)
          res = price-minPrice;
      }
      return res;
    }
}
