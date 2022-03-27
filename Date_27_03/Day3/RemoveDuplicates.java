public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    private static int removeDuplicates(int[] nums) {
        int pos = 0;
        int ans = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[pos]){
                nums[++pos] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
