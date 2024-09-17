package Patterns.SlowAndFast;

class LLHasCycle_141_E {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (!(slow == null || fast == null)) {
            if (slow.equals(fast)) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    return false;
                } else {
                    fast = fast.next;
                }
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}