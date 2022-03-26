public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,1,5,6};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
