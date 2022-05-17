import java.util.Stack;


public class EvalRPN {
	public int evalRPN(String[] tokens) {
		int result = 0;
		int a, b;
		Stack<Integer> integers = new Stack<>();
		for (String token : tokens) {
			if (isYunsuanfu(token)) {
				a = integers.pop();
				b = integers.pop();
				switch (token) {
					case "+":
						result = a + b;
						integers.push(result);
						break;
					case "-":
						result = b - a;
						integers.push(result);
						break;
					case "*":
						result = a * b;
						integers.push(result);
						break;
					case "/":
						result = b / a;
						integers.push(result);
						break;
					default:
						break;
				}
			} else {
				integers.push(Integer.parseInt(token));
			}
		}
		return integers.pop();
	}

	private boolean isYunsuanfu(String s) {
		return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
	}
}
