import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		//checkFun01(root,0);
		checkFun02(root);

		return resList;
	}

	//DFS--递归方式
	private void checkFun01(TreeNode node, Integer deep) {
		if (node == null) {
			return;
		}
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
	private void checkFun02(TreeNode node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(node);

		while (!que.isEmpty()) {
			List<Integer> itemList = new ArrayList<Integer>();
			int len = que.size();

			while (len > 0) {
				TreeNode tmpNode = que.poll();
				itemList.add(tmpNode.val);

				if (tmpNode.left != null) {
					que.offer(tmpNode.left);
				}
				if (tmpNode.right != null) {
					que.offer(tmpNode.right);
				}
				len--;
			}

			resList.add(itemList);
		}

	}


	public List<List<Integer>> solution1(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Deque<TreeNode> que = new LinkedList<>();
		if (root == null) {
			return list;
		}
		que.offerLast(root);

		while (!que.isEmpty()) {
			List<Integer> itemList = new ArrayList<>();
			int len = que.size();
			while (len-- > 0) {
				TreeNode tmpNode = que.pollFirst();
				itemList.add(tmpNode.val);
				if (tmpNode.left != null) {
					que.offerLast(tmpNode.left);
				}
				if (tmpNode.right != null) {
					que.offerLast(tmpNode.right);
				}
				list.add(itemList);
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}
}
