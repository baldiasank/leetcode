package org.example;

import lombok.ToString;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(9))));
        ListNode l2 = new ListNode(5, new ListNode(4, new ListNode(9)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode sumReference = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sumReference = sumReference.next = new ListNode(sum % 10);

        }

        while (carry > 0) {
            sumReference = sumReference.next = new ListNode(carry % 10);
            carry = carry / 10;
        }
        return result.next;
    }


}

@ToString
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}