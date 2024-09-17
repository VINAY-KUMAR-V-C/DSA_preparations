package Patterns.InPlaceReverseLinkedList;

// 3 steps
// go till left : add one prefix value and go till left value
// diff and reverse: from left to right reverse using reverse method
// add rest : move till right and add rest 

class ReverseLinkedList2_92_M {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode dummyCopy = dummy;
        int i=1;
        while (i<left){
            dummy = dummy.next;
            i++;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = dummy.next;
        int diff = right-left;
        i=0;
        while (i<=diff){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        dummy.next = prev;
        i=0;
        while(i<=diff){
            dummy = dummy.next;
            i++;
        }
        dummy.next = next;
        return dummyCopy.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1,null);
        new ReverseLinkedList2_92_M().reverseBetween(node,1,1);
    }
}