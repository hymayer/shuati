import java.util.*;

public class MaxLianxuSubStr {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		if (s == null || s.length() <= 0) {
			System.out.print(s);
			return;
		}

		HashMap<Character, Integer> charMap = new HashMap<>();
		String result = "";
		for (int i = 0, j = 0; j < s.length(); j++) {
			if (s.charAt(j) < 97 || s.charAt(j) > 122) {
				throw new IllegalArgumentException("illegal argument! " + s.charAt(j));
			}
			if (i < j && s.charAt(j) != s.charAt(j - 1) + 1) {
				i = j;
			}
			if (charMap.containsKey(s.charAt(j))) {
				i = Math.max(i, charMap.get(s.charAt(j)) + 1);
			}
			charMap.put(s.charAt(j), j);
			if (j - i + 1 > result.length()) {
				result = s.substring(i, j + 1);
			}
		}
		System.out.print(result);
	}
}
