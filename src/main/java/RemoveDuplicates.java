import java.util.Stack;

public class RemoveDuplicates {
	public String removeDuplicates(String s) {
		Stack<Character> characters = new Stack<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (characters.isEmpty() || characters.peek() != ch) {
				characters.push(ch);
			} else {
				characters.pop();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!characters.isEmpty()) {
			sb.append(String.valueOf(characters.pop()));
		}
		return sb.toString();
	}
}
