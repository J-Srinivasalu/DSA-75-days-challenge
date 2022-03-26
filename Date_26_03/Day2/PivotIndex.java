public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,3,6,2,1,6};
        System.out.println(pivotIndex(nums));
    }
    private static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        if(prefixSum[n-1] - prefixSum[0] == 0){
            return 0;
        }
        
        for(int i=1;i<n-1;i++){
            if(prefixSum[i-1] == prefixSum[n-1] - prefixSum[i]){
                return i;
            }
        }
    
        if(prefixSum[n-2] == 0){
            return n-1;
        }
        return -1;
        
    }

    private static int pivotIndexOptimized(int[] A) {
        int left = 0, sum = 0;
        for(int i=0;i<A.length;i++) {
            sum += A[i];
        }
        for(int i=0;i<A.length;i++) {
            sum -= A[i];
            if(sum == left) return i;
            left += A[i];
        }
        return -1;
        // TC : O(N)
        // SC : O(1)
    }
}
