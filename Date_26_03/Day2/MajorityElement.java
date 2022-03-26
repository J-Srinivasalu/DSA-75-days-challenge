import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        
    }

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return nums[l/2];
    }

    private static int majorityElementOptimized1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return Collections.max(map.values());
    }

    private static int majorityElementOptimized2(int[] nums){
        int ans = 0;
        return ans;
    }

}
