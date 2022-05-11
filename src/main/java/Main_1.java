import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list=new ArrayList<>();
        for(int i=0; i<n; i++) {
            String s = in.next();
            list.add(s);
        }

        Collections.sort(list);

        for(String s:list){
            System.out.println(s);
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLong()) {
//            long number = scanner.nextLong();
//            getPrimerFactors(number);
//        }
//    }

//    private static void getPrimerFactors(long num) {
//        long number = num;
//        while (number != 1) {
//            if (isPrimeNumber(number)) {
//                System.out.print(number);
//                return;
//            } else {
//                for (int i = 2; i < number; i++) {
//                    if (number % i == 0) {
//                        number /= i;
//                        System.out.print(i + " ");
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    private static boolean isPrimeNumber(long num) {
//        if (num == 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

        //HJ3 明明的随机数
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        Set<Integer> nums = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            int num = Integer.parseInt(in.nextLine());
//            nums.add(num);
//        }
//        for (Integer it : nums) {
//            System.out.println(it);
//        }
//    }

//    //HJ3 明明的随机数（堆排序）
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        int[] heap = new int[n];
//        //1.构建小顶堆
//        for (int i = 0; i < n; i++) {
//            int num = Integer.parseInt(in.nextLine());
//            heapInsert(heap, i, num);
//        }
//        //2.从堆中取出元素，完成排序
//        int[] sortArray = new int[heap.length];
//        //调整堆结构+交换堆顶元素与末尾元素
//        int i = 0;
//        for (int j = heap.length - 1; j >= 0; j--) {
//            sortArray[i++] = heap[0];
//            swap(heap, 0, j);
//            //重新对堆进行调整
//            heapify(heap, 0, j);
//        }
//        System.out.println(Arrays.toString(sortArray));
//    }
//
//    /**
//     * 自底向上调整堆
//     * @param heap
//     * @param i //现在插入的是第几个元素
//     * @param num //第i个元素的数值大小
//     */
//    public static void heapInsert(int[] heap, int i, int num) {
//        heap[i] = num;
//        while (heap[i] < heap[(i - 1) / 2]) {
//            swap(heap, i, (i - 1) / 2);
//            i = (i - 1) / 2;
//        }
//    }
//
//    /**
//     *
//     * @param heap
//     * @param i //当前需要调整的元素
//     * @param heapSize //当前堆的大小
//     */
//    public static void heapify(int[] heap, int i, int heapSize) {
//        int left = i * 2 + 1;
//        while (left < heapSize) {
//            // 选择左右叶子节点中更小的节点与父节点交换（记为largest）
//            int largest = (left + 1 < heapSize) && heap[left + 1] < heap[left] ? left + 1 : left;
//            if (heap[largest] < heap[i]) {
//                swap(heap, i, largest);
//                i = largest;
//                left = largest * 2 + 1;
//            } else {
//                break;
//            }
//        }
//
//    }
//
//    /**
//     * 交换元素
//     * @param arr
//     * @param a
//     * @param b
//     */
//    public static void swap(int []arr,int a ,int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }


    //HJ2 计算某字符出现次数
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String character = in.nextLine();
//        int t = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (String.valueOf(s.charAt(i)).equalsIgnoreCase(character)) {
//                t++;
//            }
//        }
//        System.out.println(t);
//    }


//    //HJ1 字符串最后一个单次的长度
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String[] strArray = s.split(" ");
//        if (strArray.length <= 0) {
//            System.out.println(0);
//        } else {
//            System.out.println(strArray[strArray.length - 1].length());
//        }
//    }
}