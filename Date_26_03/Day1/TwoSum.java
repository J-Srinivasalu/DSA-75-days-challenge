import java.util.*;

class TwoSum{
    public static void main(String[] args) {
        int[] nums = {11,2,3,7,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumOptimized(nums, target)));
    }
    private static int[] twoSumBruteforce(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    private static int[] twoSumOptimized(int[] nums, int target){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}