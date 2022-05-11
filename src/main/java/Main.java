import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] array = new int[n][2];
		for (int i = 0; i < n; i++) {
			array[i][0] = scanner.nextInt();
			array[i][1] = scanner.nextInt();
		}
		if (n > 3) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}
}
