public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {2,3,4,5,1,9,3};
        System.out.println(maxProfiteOptimized2(prices));
    }

    private static int maxProfitBruteForce(int[] prices){
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            for(int j= i+1;j<prices.length;j++){
                int currProfit = prices[j] - prices[i];
                if(currProfit > max){
                    max = currProfit;
                }
            }
        }
        return max;
    }

    private static int maxProfiteOptimized1(int[] prices){
        int max = 0;
        int n = prices.length;
        int[] maxProf = new int[n];
        maxProf[n-1] = prices[n-1];
        int prevMax = maxProf[n-1];
        for(int i=n-2;i>=0;i--){
            if(prices[i] > prevMax){
                prevMax = prices[i];
            }
                maxProf[i] = prevMax;
        }

        for(int i=0;i<n;i++){
            if(maxProf[i]-prices[i] > max){
                max = maxProf[i]-prices[i];
            }
        }

        return max;
    }

    private static int maxProfiteOptimized2(int[] prices){
        int max = 0;
        int minPrice = prices[0];

        for(int i=0;i<prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            int currProfit = prices[i] - minPrice;
            max = Math.max(max, currProfit);
        }

        return max;
    }
}
