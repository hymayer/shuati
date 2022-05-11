import java.util.List;

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
public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //设置虚拟节点
        ListNode returnNode = new ListNode(-1, head);
        ListNode cur = returnNode;
        ListNode temp = head;
        ListNode temp2;
        while (temp != null && temp.next != null) {
            cur.next = temp.next;
            temp2 = temp.next.next;
            temp.next.next = temp;
            temp.next = temp2;
            cur = temp;
            temp = temp2;
        }
        return returnNode.next;
    }
}