import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> result;
    public LinkedList<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        backtracking(k, n, 0, 1);
        return result;
    }

    private void backtracking(int k, int n, int sum, int startIndex) {
        if (sum >= n || path.size() >= k) {
            if (sum == n && path.size() == k) {
                result.add(new LinkedList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        CombinationSum3 combinationSum3 = new CombinationSum3();
        combinationSum3.combinationSum3(k, n);
    }
}