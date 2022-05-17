import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            addVal(deque, nums, i);
        }
        for (int i = 0; i < result.length; i++) {
            if (!deque.isEmpty()) {
                result[i] = nums[deque.peekFirst()];
            }
            if (i + k < nums.length) {
                addVal(deque, nums, i + k);
                if (!deque.isEmpty() && deque.peekFirst() == i) {
                    deque.removeFirst();
                }
            }

        }
        return result;
    }

    private void addVal(Deque<Integer> deque, int[] nums, int val) {
        while (!deque.isEmpty() && nums[deque.getLast()] <= nums[val]) {
            deque.removeLast();
        }
        deque.addLast(val);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, k)));
    }
}