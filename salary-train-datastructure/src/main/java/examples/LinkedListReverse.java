package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/17
 * @description:
 **/
public class LinkedListReverse {

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "[" + (this.value) + "]-->[" + ((null == next) ? "" : next.value) + "]";
        }
    }

    public static Node reverse(Node root) {
        Node current = root;
        Node pre = null;
        while (current != null) {
            Node tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.next = node1;
        System.out.println(node);
        System.out.println(reverse(node));
    }
}
