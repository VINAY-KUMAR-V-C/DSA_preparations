package Patterns.TopKEle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class KPairsWithSmallestSum_373_M {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        minHeap = new ArrayList<>();
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        int i=0;
        int j=0;
        int count = 1;
        List<Integer> first = new ArrayList<>();
        first.add(nums1[0]);
        first.add(nums2[0]);
        res.add(first);
        while(i<nums1Len && j<nums2Len && count<k){
            if((i+1)<nums1Len && !visited[i+1][j]){
                visited[i+1][j] = true;
                insertValue(new Node(i+1, j, nums1[i+1], nums2[j]));
            }
            if((j+1)<nums2Len && !visited[i][j+1]){
                visited[i][j+1] = true;
                insertValue(new Node(i, j+1, nums1[i], nums2[j+1]));
            }
            count++;
            Node node = minHeap.get(0);
            heapifyDown(0);
            ArrayList<Integer> subRes= new ArrayList<>();
            subRes.add(nums1[node.i]);
            subRes.add(nums2[node.j]);
            res.add(subRes);
            i = node.i;
            j = node.j;
        }
        return res;
    }
    ArrayList<Node> minHeap;
    void insertValue(Node val){
        minHeap.add(val);
        heapifyUp();
    }
    void heapifyDown(int i){
        Node lastIndexValue = minHeap.remove(minHeap.size()-1);
        int length = minHeap.size();
        if(length==0){
            return;
        }
        minHeap.set(i,lastIndexValue);
        while(!isLeafNode(i)){
            int leftInd = getChild(i, true);
            int rightInd = getChild(i,false);
            int minInd = i;
            if(leftInd<length && minHeap.get(leftInd).sum<minHeap.get(minInd).sum){
                minInd = leftInd;
            }
            if(rightInd<length && minHeap.get(rightInd).sum<minHeap.get(minInd).sum){
                minInd = rightInd;
            }
            if(minInd==i){
                break;
            }else{
                swap(i, minInd);
                i=minInd;
            }
        }
    }
    void heapifyUp(){
        int length = minHeap.size();
        int i=length-1;
        while(i>0){
            if(minHeap.get(i).sum<minHeap.get(getParentInd(i)).sum){
                swap(i,getParentInd(i));
                i = getParentInd(i);
            }else{
                break;
            }
        }
    }
    void swap(int i,int j){
        Node left = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, left);
    }   
    boolean isLeafNode(int i){
        return i<minHeap.size() && i>=(minHeap.size())/2;
    }

    int getChild(int i,boolean isLeft){
        return isLeft?i*2+1: i*2+2;
    }

    int getParentInd(int i){
        return (i-1)/2;
    }
    class Node{
        int i;
        int j;
        int sum;
        Node(int i,int j,int left,int right){
            this.i = i;
            this.j = j;
            this.sum = left+right;
        }
    }
    public static void main(String[] args) {
        new KPairsWithSmallestSum_373_M().kSmallestPairs(new int[]{1,2,4,5,6}, new int[]{3,5,7,9},20);
        //new KPairsWithSmallestSum_373_M().kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6},3);
        //res = [[1,1],[1,4]]
    }
}