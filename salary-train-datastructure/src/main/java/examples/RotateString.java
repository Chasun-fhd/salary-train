package examples;

/**
 * @author:haidong.feng
 * @createdAt:2020/10/28
 * @description:
 **/
public class RotateString {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(n1);
        System.out.println("--------------------");
        ListNode node = rotateRight(n1, 2);
        System.out.println(node);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        //make circle
        ListNode circle = head;
        while (head != null && head.next != null) {
            head = head.next;
        }

        head.next = circle;

        //find new head.
        int len = 0;
        ListNode newHead = circle;
        while (newHead != null && (len++) <= k) {
            newHead = newHead.next;
        }
        //System.out.println("newHead:" + newHead.val);
        //System.out.println("circle:" + circle);

        ListNode newTail = circle;
        while (newTail.next != null && newTail.next != newHead) {
            newTail = newTail.next;
        }
        //System.out.println("newTail:" + newTail.val);
        //break circle
        newTail.next = null;
        return newHead;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    '}';
        }
    }
}
