//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Copyright 2022, Xiaomi.
// * All rights reserved.
// * Author: huyumei@xiaomi.com
// */
//public class SlidingWindow {
//	/* 滑动窗⼝算法框架 */
//	public void slidingWindow(String s, String t) {
//		Map<Character, Integer> need = new HashMap<>();
//		Map<Character, Integer> window = new HashMap<>();
//		for (Character c : t.toCharArray()) {
//			if (need.containsKey(c)) {
//				need.put(c, need.get(c) + 1);
//			} else {
//				need.put(c, 1);
//			}
//		}
//		int left = 0, right = 0;
//		int valid = 0;
//		while (right < s.length()) {
//			// c 是将移⼊窗⼝的字符
//			char c = s.charAt(right);
//			// 右移窗⼝
//			right++;
//			// 进⾏窗⼝内数据的⼀系列更新
//			//TODO
//			/*** debug 输出的位置 ***/
//						System.out.print("window: " + left  + right);
//			/********************/
//			// 判断左侧窗⼝是否要收缩
//			while (window needs shrink) {
//      // d 是将移出窗⼝的字符
//				char d = s.charAt(left);
//			// 左移窗⼝
//				left++;
//			// 进⾏窗⼝内数据的⼀系列更新
//      //TODO
//			}
//		}
//	}
//}
