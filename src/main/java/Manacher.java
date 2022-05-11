import java.util.*;

public class Manacher {
//    public static int Plalindrome(String str) {
//        if (str == null || str.length() == 0) {
//            return -1;
//        }
//
//        char[] c = str.toCharArray();
//
//        char[] newC = new char[c.length * 2 + 1];
//        newC[0] = '#';
//
//        // c的指针
//        int i = 0;
//        // newC的指针
//        int j = 1;
//
//        // 使用辅助字符#处理原字符串
//        while (i < c.length && j < newC.length - 1) {
//            newC[j ++] = c[i ++];
//            newC[j ++] = '#';
//        }
//
//        return process(newC);
//    }
//
//    private static int process(char[] str) {
//        // 回文区域数组
//        int[] next = new int[str.length];
//
//        //构建回文区域数组
//        for (int i = 0; i < str.length; i ++) {
//            int j = i - 1;
//            int k = i + 1;
//            // 回文区域最少是1，为本身
//            int count = 1;
//            // 向两边每个字符进行匹配
//            while (j >= 0 && k != str.length) {
//                if (str[j] != str[k]) {
//                    break;
//                }
//                j --;
//                k ++;
//                count = count + 2;
//            }
//            next[i] = count;
//        }
//
//        // 回文区域数组升序排序
//        Arrays.sort(next);
//
//        // 回文区域数组中最大的元素除以2就是最大回文子串长度
//        return next[next.length - 1] / 2;
//    }



    public static int plalindrome(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        char[] c = str.toCharArray();

        char[] newC = new char[c.length * 2 + 1];
        newC[0] = '#';

        // c的指针
        int i = 0;
        // newC的指针
        int j = 1;

        // 使用辅助字符#处理原字符串
        while (i < c.length && j < newC.length - 1) {
            newC[j ++] = c[i ++];
            newC[j ++] = '#';
        }

        return process(newC);
    }

    public static int process(char[] str) {
        // 这里的R和定义中有些不同，这里是指i之前字符的回文区域最右边的下标的后一位，也就是说R-1才是回文区域最右边的下标
        int R = -1;
        // 中心
        int C = -1;

        // 回文半径数组
        int[] next = new int[str.length];

        for (int i = 0; i < str.length; i ++) {
            // 先确定所有情况中最低回文半径
            // 如果i > R，表示第一种大情况，最低回文半径为自身为1
            // 如果 i < R，表示第二种大情况：
            // 如果是第①种小情况，i'的回文半径会比R-i小，直接可以确定为i'的回文半径
            // 如果是第②种小情况，i’的回文半径会比R-i大，直接可以确定为R-i
            // 如果是第③种小情况，i’的回文半径和R-i相等，虽然不能确定最终的回文半径，但是可以确定最少就是i'的回文半径或R-i
            next[i] = i < R ? Math.min(next[2 * C - i], R - i) : 1;

            // 无论是遇到哪一种情况都会尝试着往外扩，因为只有第一种大情况和第二种大情况的第③种小情况需要向外扩，因此如果是第二中大情况的
            // 第①种小情况或者第②种小情况虽然也会走向外扩的流程，但是第一次就会失败，从而跳出循环。
            // 这是为了省略多个if-else所做的一个统一的流程，优化了代码的长度，并不会影响时间复杂度
            while (i + next[i] < str.length && i - next[i] >= 0) {
                if (str[i + next[i]] == str[i - next[i]]) {
                    next[i] ++;
                } else {
                    break;
                }
            }

            // 判断R和C是否需要更新
            if (i + next[i] > R) {
                // R向右扩
                R = i + next[i];
                // 此时i就是当前所有字符的回文区域达到最右的区域的中心点
                C = i;
            }
        }

        // 给next数组排序，找到最大的回文半径
        Arrays.sort(next);
        int maxPalindromeRadius = next[str.length - 1];

        // 处理串中i位的回文半径长度 - 1 = 原串中以i为对称轴的回文子串长度
        return maxPalindromeRadius - 1;
    }

}