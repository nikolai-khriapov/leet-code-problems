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
    public int pairSum(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first = dummy.next;
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);

        int maxTwinSum = Integer.MIN_VALUE;
        while (first != null && second != null) {
            maxTwinSum = Math.max(maxTwinSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        
        return maxTwinSum;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}

// time  - O(n)
// space - O(1)
