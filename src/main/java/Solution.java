import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    //bubbleSort 超时 O(N^2)
    public ListNode bubbleSort(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode returnNode = head;
        while (head.next != null) {
            ListNode nextNode = head.next;
            while (nextNode != null) {
                if (head.val > nextNode.val) {
                    int temp = nextNode.val;
                    nextNode.val = head.val;
                    head.val = temp;
                }
                nextNode = nextNode.next;
            }
            head = head.next;
        }
        return  returnNode;
    }

    //mergeSort
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }
        return this.sort(head, 0, size - 1);
    }

    private ListNode sort(ListNode head, int l, int r) {
        if (l == r) {// 只有一个节点的时候返回
            return head;
        }
        int mid = ((r - l) >> 1) + l;// 分割点
        ListNode p = head;// p是分割点前的节点
        int move = mid - l;
        while (move > 0) {// 移动到分割点前
            p = p.next;
            move--;
        }
        ListNode next = p.next;// 第二个链表的头
        p.next = null;// 链表一分为二
        // 二分排序，将各自排序的结果用merge合并
        return this.merge(this.sort(head, l, mid), this.sort(next, mid + 1, r));
    }

    private ListNode merge(ListNode head, ListNode p) {
        ListNode p1 = new ListNode();// 走针，随着节点增加，向后移动
        ListNode p2 = p1;// 头针，拿住头，才能返回
        while (head != null && p != null) {// 将head和p中小的节点接到结果上
            if (head.val < p.val) {
                p1.next = head;
                head = head.next;// 接的节点走，不接的节点不走
            } else {
                p1.next = p;
                p = p.next;
            }
            p1 = p1.next;// 每接一个节点向后走一步
        }
        while (head != null) {// 长处来的一定是排好序，且比较大的节点，head和p满足其一
            p1.next = head;
            head = head.next;
            p1 = p1.next;
        }
        while (p != null) {// 长处来的一定是排好序，且比较大的节点，head和p满足其一
            p1.next = p;
            p = p.next;
            p1 = p1.next;
        }
        return p2.next;
    }


    // 通过快慢指针找到链表的中点
    public ListNode findMidListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int i = 0;
        int[] result = new int[nums.length];
        while (i < nums.length) {
            push(nums, i);
            i++;
        }

        int index = nums.length - 1;
        int j = 0;
        while (index >= 0) {
            result[j++] = pop(nums, index);
            index--;
        }

        return result;
    }

    private void push(int[] nums, int index) {
        int father = (index - 1)/2;
        while (father >= 0) {
            if ((nums[father] > nums[index])) {
                swap(nums, index, father);
            }
            index = father;
            if (index == 0) {
                return;
            }
            father = (index - 1)/2;
        }
    }


    private int pop(int[] nums, int index) {
        int min = nums[0];

        swap(nums, 0, index);
        int i = 0;
        while (((i * 2) + 1) < index) {
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if (rightChild < index && nums[rightChild] < nums[leftChild]) {
                swap(nums, i , rightChild);
                i = rightChild;
            } else {
                if (nums[i] > nums[leftChild]) {
                    swap(nums, i , leftChild);
                }
                i = leftChild;
            }
        }

        return min;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
}