import java.util.HashMap;

public class TotalFruit {

    public int totalFruit(int[] fruits) {
        int cnt = 0, left = 0, right = 0;
        int fruitA = fruits[left], fruitB = fruits[right];
        while(right < fruits.length) {
            if(fruits[right] == fruitA || fruits[right] == fruitB) {
                cnt = Math.max(cnt, right - left + 1);
                right++;
            } else {
                left = right - 1;
                fruitA = fruits[left];
                while(left > 0 && fruits[left - 1] == fruitA) {
                    left--;
                }
                fruitB = fruits[right];
                cnt = Math.max(cnt, right - left + 1);
            }
        }
        return cnt;
    }

//    public int totalFruit(int[] fruits) {
//        if (fruits.length <= 1) {
//            return fruits.length;
//        }
//
//
//        int result = 1;
//        int sum = 1;
//        int left = 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(2);
//        hashMap.put(fruits[left], 1);
//        int right = 1;
//        while (left <= right && right < fruits.length) {
//            if (hashMap.size() <= 2 && hashMap.containsKey(fruits[right])) {
//                hashMap.put(fruits[right], hashMap.get(fruits[right]) + 1);
//                right++;
//                sum++;
//                result = Math.max(result, sum);
//            } else if (hashMap.size() <= 1) {
//                hashMap.put(fruits[right++], 1);
//                sum++;
//                result = Math.max(result, sum);
//            } else {
//                hashMap.put(fruits[left], hashMap.get(fruits[left]) - 1);
//                if (hashMap.get(fruits[left]) <= 0) {
//                    hashMap.remove(fruits[left++]);
//                }
//                sum--;
//            }
//        }
//
//        return result;
//    }




    public static void main(String[] args) {
        int[] fruits = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(fruits));
    }
}

//fruits = [3,3,3,1,2,1,1,2,3,3,4]