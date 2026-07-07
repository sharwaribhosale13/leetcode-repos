/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Find length and last node
        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0)
            return head;

        // Make circular list
        tail.next = head;

        // Find new tail
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++)
            newTail = newTail.next;

        // Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}