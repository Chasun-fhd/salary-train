package leetcode.problems;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/14
 * @description:
 **/
public class OddEvenLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        ListNode evenHead = head.next;
        ListNode even = evenHead, odd = head;
        while ( even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        System.out.println(head);
    }


    static class ListNode {

        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

        @Override
        public String toString() {
            return this.val+"->" + (null != this.next ? this.next.val : "");
        }
    }
}
