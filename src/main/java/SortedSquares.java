import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] result  = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int i = nums.length - 1;
        while (leftIndex <= rightIndex && i >= 0) {
            while ((leftIndex < rightIndex) && nums[leftIndex] * nums[leftIndex] <= nums[rightIndex] * nums[rightIndex]) {
                result[i--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }

            while ((leftIndex < rightIndex) && nums[leftIndex] * nums[leftIndex] > nums[rightIndex] * nums[rightIndex]) {
                result[i--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }

            if (leftIndex == rightIndex) {
                result[i--] = nums[leftIndex] * nums[leftIndex];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10000,-9999,-7,-5,0,0,10000};
        SortedSquares sortedSquares = new SortedSquares();
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
    }
}