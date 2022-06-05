
//Definition for singly-linked list.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int x, y, total;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) x = l1.val;
            else x = 0;
            if (l2 != null) y = l2.val;
            else y = 0;
            total = x + y + carry;
            carry = total / 10;
            if (head == null) {
                head = tail = new ListNode(total % 10);
            } else {
                tail.next = new ListNode(total % 10);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);
        return head;
    }
}

class main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        Solution solution = new Solution();
        ListNode head = solution.addTwoNumbers(l1, l2);
        System.out.println("val:" + head.val);
    }
}

