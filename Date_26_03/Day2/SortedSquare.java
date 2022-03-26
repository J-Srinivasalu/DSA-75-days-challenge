import java.util.Arrays;

public class SortedSquare {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -1, 0, 2, 5, 8};
        System.out.println(Arrays.toString(sortedSquaresOptimized(nums)));
    }
    private static int[] sortedSquaresOptimized(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n-1;

        for(int k=n-1;k>=0;k--) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[k] = nums[i]*nums[i];
                i++;
            }else{
                ans[k] = nums[j]*nums[j];
                j--;
            }
        }

        return ans;
    }
}
