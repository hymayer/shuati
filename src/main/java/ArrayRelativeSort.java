import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Copyright 2022, Xiaomi.
 * All rights reserved.
 * Author: huyumei@xiaomi.com
 */
public class ArrayRelativeSort {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
			HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(arr2.length);

			for (int i = 0; i < arr2.length; i++) {
				hashMap.put(arr2[i], 0);
			}

			for (int i = 0; i < arr1.length; i++) {
				if (hashMap.containsKey(arr1[i])) {
					hashMap.put(arr1[i], hashMap.get(arr1[i]) + 1);
				} else {
					treeMap.put(arr1[i], treeMap.getOrDefault(arr1[i], 0) + 1);
				}
			}

			int index = 0;

			for (int i = 0; i < arr2.length; i++) {
				for (int j = 0; j < hashMap.get(arr2[i]); i++) {
					arr1[index++] = arr2[i];
				}
			}

			while (index < arr1.length) {
				Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();
				for(int i = 0; i < entry.getValue(); i++){
					arr1[index++] = entry.getKey();
				}
			}

			return arr1;
	}

	private static int[] qsort(int arr[], int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (( i < j) && (arr[j] > pivot)) {
				j--;
			}
			while ((i < j) && (arr[i] < pivot)) {
				i++;
			}
			if ((arr[i] == arr[j]) && (i < j)) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if (i - 1 > start) {
			arr = qsort(arr, start,i-1);
		}
		if (j + 1 < end) {
			arr = qsort(arr,j+1, end);
		}
		return (arr);
	}



	public static void main(String[] args) {
		int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
		int len = arr.length-1;
		long startTime = System.currentTimeMillis();
		arr = qsort(arr,0,len);
		for (int i:arr) {
			System.out.print(i+"\t");
		}
		System.out.println("use time: " + (System.currentTimeMillis() - startTime));
	}
}
