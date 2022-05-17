import java.util.Scanner;

/**
 * Copyright 2022, Xiaomi.
 * All rights reserved.
 * Author: huyumei
 */
public class DayOfWeek {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		System.out.println(year + "年" + month + "月" + day + "日" + " 是星期" + getDayOfWeek(year, month, day));
	}

	private static int getDayOfWeek(int year, int month, int day) {
		int days = 0;
		for (int i = 1979; i < year; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				days++;
			}
			days += 365;
		}
		switch (month) {
			case 2:
				days += 31;
				break;
			case 3:
				days += 59;
				break;
			case 4:
				days += 90;
				break;
			case 5:
				days += 120;
				break;
			case 6:
				days += 151;
				break;
			case 7:
				days += 181;
				break;
			case 8:
				days += 212;
				break;
			case 9:
				days += 243;
				break;
			case 10:
				days += 273;
				break;
			case 11:
				days += 304;
			case 12:
				days += 334;
				break;
			default:
				break;
		}
		if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) {
			days++;
		}
		days += day;
		return days % 7 == 0 ? 7 : days % 7;
	}
}
