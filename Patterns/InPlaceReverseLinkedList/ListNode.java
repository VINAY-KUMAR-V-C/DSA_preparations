package Patterns.InPlaceReverseLinkedList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class ListNode {
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
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> val = new ArrayList<>();
        traverse(val, root, 0);
        return val;
    }
    public void traverse(List<List<Integer>> val,TreeNode root,int ind){
        if(root==null){
            return;
        }else{
            if(val.size()==ind){
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                val.add(list);
            }else{
                val.get(ind).add(root.val);
            }
            traverse(val, root.left, ind);
        }
    }
}
