public class p287 {
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[fast];
    }
}
