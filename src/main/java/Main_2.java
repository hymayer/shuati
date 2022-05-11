import java.util.*;

public class Main_2 {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) {
				String nowCard = scanner.nextLine();
				String doneCard = scanner.nextLine();
				String[] nowCards = nowCard.split("-");
				String[] doneCards = doneCard.split("-" );
				Map<Integer, Integer> stringIntegerMap = new TreeMap<>();
				for (int i = 3; i < 15; i++) {
					stringIntegerMap.put(i, 4);
				}
				for (String now : nowCards) {
					int num = getIntOfString(now);
					if (num > 2 && num < 15) {
						stringIntegerMap.put(num, stringIntegerMap.get(num) - 1);
					}
				}
				for (String done : doneCards) {
					int num = getIntOfString(done);
					if (num > 2 && num < 15) {
						stringIntegerMap.put(num, stringIntegerMap.get(num) - 1);
					}
				}
				int[] cardSet = new int[12];
				int i = 0;
				for (Map.Entry<Integer, Integer> entry : stringIntegerMap.entrySet()) {
					cardSet[i++] = entry.getValue();
				}

				int largest = 0;
				int begin = 0;
				int slow = 0;
				int fast = 0;
				while (fast < cardSet.length) {
					while (fast < cardSet.length && cardSet[fast] > 0) {
						fast++;
					}
					if (fast > 0 && largest < fast - slow + 1) {
						largest = fast - slow;
						begin = slow;
					}
					fast++;
					slow = fast;
				}

				if (largest < 5) {
					System.out.print("NO-CHAIN");
				} else {
					StringBuilder sb = new StringBuilder();
					for (int j = begin; j < begin + largest - 1; j++) {
						sb.append(getStrOfInt(j + 3)).append("-");
					}
					sb.append(getStrOfInt(begin + largest - 1 + 3));
					System.out.print(sb.toString());
				}
			}
	}

	private static int getIntOfString(String s) {
		if ("J".equalsIgnoreCase(s)) {
			return 11;
		} else if ("Q".equalsIgnoreCase(s)) {
			return 12;
		} else if ("K".equalsIgnoreCase(s)) {
			return 13;
		} else if ("A".equalsIgnoreCase(s)) {
			return 14;
		} else if ("B".equalsIgnoreCase(s)) {
			return 15;
		} else if ("C".equalsIgnoreCase(s)) {
			return 16;
		} else {
			return Integer.parseInt(s);
		}
	}

	private static String getStrOfInt(int i) {
		if (i == 11) {
			return "J";
		} else if (i == 12) {
			return "Q";
		} else if (i == 13) {
			return "K";
		} else if (i == 14) {
			return "A";
		} else {
			return String.valueOf(i);
		}
	}
}
