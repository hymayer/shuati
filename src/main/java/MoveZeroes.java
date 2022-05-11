public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        for (; slowIndex < nums.length; slowIndex++) {
            nums[slowIndex] = 0;
        }
    }
}