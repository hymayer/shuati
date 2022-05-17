import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
    	this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
    	this.val = val;
    	this.left = left;
    	this.right = right;
    }


	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		if (root == null) {
			return result;
		} else {
			st.push(root);
		}

		while (!st.isEmpty()) {
			TreeNode node = st.peek();
			//前序 对应压栈顺序右左中
			if (node != null) {
				st.pop();
				//空节点不入栈
				if (node.right != null) {
					st.push(node.right);
				}
				if (node.left != null) {
					st.push(node.left);
				}
				st.push(node);
				st.push(null);//增加null作为弹出的标志
			} else {
				st.peek();
				st.pop();//先把栈顶的null弹出
				node = st.peek();
				result.add(node.val);
				st.pop();
			}
		}

		return result;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		if (root != null) {
			st.push(root);
		}

		while (!st.isEmpty()) {
			TreeNode node = st.peek();
			if (node != null) {
				//压栈顺序后中左
				st.pop();
				if (node.right != null) {
					st.push(node.right);
				}
				st.push(node);
				st.push(null);
				if (node.left != null) {
					st.push(node.left);
				}
			} else {
				st.pop();
				node = st.peek();
				st.pop();
				result.add(node.val);
			}
		}

		return result;
	}


	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		if (root != null) {
			st.push(root);
		}

		while (!st.isEmpty()) {
			TreeNode node = st.peek();
			if (node != null) {
				//压栈顺序前右左
				st.push(null);
				if (node.right != null) {
					st.push(node.right);
				}
				if (node.left != null) {
					st.push(node.left);
				}
			} else {
				st.pop();
				node = st.peek();
				st.pop();
				result.add(node.val);
			}
		}

		return result;
	}


	//层序遍历
	public List<List<Integer>> resList = new ArrayList<List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		//checkFun01(root,0);
		checkFun02(root);

		return resList;
	}

	//DFS--递归方式
	public void checkFun01(TreeNode node, Integer deep) {
		if (node == null) return;
		deep++;

		if (resList.size() < deep) {
			//当层级增加时，list的Item也增加，利用list的索引值进行层级界定
			List<Integer> item = new ArrayList<Integer>();
			resList.add(item);
		}
		resList.get(deep - 1).add(node.val);

		checkFun01(node.left, deep);
		checkFun01(node.right, deep);
	}

	//BFS--迭代方式--借助队列
	public void checkFun02(TreeNode node) {
		if (node == null) return;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(node);

		while (!que.isEmpty()) {
			List<Integer> itemList = new ArrayList<Integer>();
			int len = que.size();

			while (len > 0) {
				TreeNode tmpNode = que.poll();
				itemList.add(tmpNode.val);

				if (tmpNode.left != null) que.offer(tmpNode.left);
				if (tmpNode.right != null) que.offer(tmpNode.right);
				len--;
			}

			resList.add(itemList);
		}
	}
}



