public class Solution {
    // best solution
    /*
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for(int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        
        return sell;
    }
    */
    
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buys[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] + price[1]);
        for(int i = 2; i < len; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - price[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + price[i]);
        }
        
        return sell[len - 1];
    }
}