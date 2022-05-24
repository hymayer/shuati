import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FindMode {
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list.stream().mapToInt(Integer::intValue).toArray();
		}
		// 获得频率 Map
		searchBST(root, map);
		List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
				.sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
				.collect(Collectors.toList());
		list.add(mapList.get(0).getKey());
		// 把频率最高的加入 list
		for (int i = 1; i < mapList.size(); i++) {
			if (mapList.get(i).getValue().equals(mapList.get(0).getValue())) {
				list.add(mapList.get(i).getKey());
			} else {
				break;
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	void searchBST(TreeNode curr, Map<Integer, Integer> map) {
		if (curr == null) {
			return;
		}
		map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
		searchBST(curr.left, map);
		searchBST(curr.right, map);
	}

}