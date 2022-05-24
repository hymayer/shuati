import java.util.ArrayDeque;

//DFS递归
public class BFSBinaryTree {
   /**
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），
     * 再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        invertTree(root.left);
//        invertTree(root.right);
//        swapChildren(root);
//        return root;
//    }

    private void swapChildren(BinaryTree root) {
        BinaryTree tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }


//BFS
    public BinaryTree invertTree(BinaryTree root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<BinaryTree> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            while (size-- > 0) {
                BinaryTree node = arrayDeque.getFirst();
                arrayDeque.pollFirst();
                swap(node);
                if (node.left != null) {
                    arrayDeque.offer(node.left);
                }
                if (node.right != null) {
                    arrayDeque.offer(node.right);
                }
            }
        }
        return root;
    }

    public void swap(BinaryTree root) {
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}