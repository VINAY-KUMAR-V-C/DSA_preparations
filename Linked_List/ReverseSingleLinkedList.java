package Linked_List;

public class ReverseSingleLinkedList {
    Node node;
    Node method(Node node){
        //logic 
        //1 2 3 4
        //curr 1 2 3 4 : take first number and move to last 
        //curr 2 3 4   : repeat
        Node pre = null;
        Node cur = node;
        Node nex = null;
        while(cur!=null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
