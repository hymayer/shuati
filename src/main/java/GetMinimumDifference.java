import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 */

public class GetMinimumDifference {
    TreeNode pre;
    Stack<TreeNode> stack;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            } else {
                cur = stack.pop();
                if (pre != null) { // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right; // 右
            }
        }
        return result;
    }
//    ArrayList<Integer> integers = new ArrayList<>();
//    public int getMinimumDifference(TreeNode root) {
//        transfer(root);
//        long min = Long.MAX_VALUE;
//
//        for (int i = 1; i < integers.size(); i++) {
//            min = Math.min(min, integers.get(i) - integers.get(i - 1));
//        }
//        return (int) min;
//    }
//
//    private void transfer(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        transfer(root.left);
//        integers.add(root.val);
//        transfer(root.right);
//    }
}