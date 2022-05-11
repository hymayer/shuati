import java.util.Stack;

/**
 * @author yumeihu
 */
public class BracketMatch {
	public boolean isValid(String s) {
		Stack<Character> characterStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				characterStack.push('}');
			} else if (s.charAt(i) == '[') {
				characterStack.push(']');
			} else if (s.charAt(i) == '(') {
				characterStack.push(')');
			} else if (s.charAt(i) == '}') {
				if (characterStack.isEmpty() || characterStack.pop() != '}') {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (characterStack.isEmpty() || characterStack.pop() != ']') {
					return false;
				}
			} else if (s.charAt(i) == ')') {
				if (characterStack.isEmpty() || characterStack.pop() != ')') {
					return false;
				}
			}
		}

		return characterStack.isEmpty();
	}
}
