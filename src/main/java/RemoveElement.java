public class RemoveElement {
    //暴力搜索法 超出时间限制
    public int removeElement_1(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    //快慢指针法
    //通过一个快指针和一个慢指针在一个for循环下完成两个for循环的工作
    //fastIndex 遍历全部元素
    //slowIndex 只一次写入符合条件的元素
    public int removeElement_2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            while ((left <= right) && val != nums[left]) {
                left++;
            }

            while ((left <= right) && val == nums[right]) {
                right--;
            }

            // 将右边不等于val的元素覆盖左边等于val的元素
            if (left < right) {
                nums[left++] = nums[right--];
            }
        }

        return left;
    }

}