package Patterns.TopKEle;

import java.util.ArrayList;

//JUST read HEAP of max and min enough
public class KthLargestEle {
    public int findKthLargest(int[] nums, int k) {
        heap = new ArrayList<>();
        for(int i:nums){
            heap.add(i);
            heapifyUp(heap.size()-1);
        }
        for (int i=1;i<k;i++){
            swap(0, heap.size()-1);
            heap.remove(heap.size()-1);
            heapifyDown(0);
        }
        return heap.get(0);
    }
    ArrayList<Integer> heap;

    void heapifyUp(int ind){
        while(ind>0 && heap.get(ind)>heap.get(getParentIndex(ind))){
            swap(ind, getParentIndex(ind));
            ind = getParentIndex(ind);
        }
    }

    void swap(int i,int j){
        heap.set(i, heap.get(j)+heap.get(i));
        heap.set(j, heap.get(i)-heap.get(j));
        heap.set(i, heap.get(i)-heap.get(j));
    }
    int getChildIndex(int i,boolean isLeft){
        if(isLeft){
            return i*2 + 1;
        }else{
            return i*2 + 2;
        }
    }
    boolean isLeafNode(int i){
        return i>=heap.size()/2 ;
    }
    int getParentIndex(int i){
        return (i-1)/2;
    }
    public void heapifyDown(int index){
        int curSize = heap.size();
        while(!isLeafNode(index)){
            int maxIndexReference = index;
            int leftIndex = getChildIndex(index,true);
            int rightIndex = getChildIndex(index,false);
            //first check left child is greater 
            if(leftIndex<curSize && heap.get(leftIndex)>heap.get(index)){
                //if left child is greater ,
                //then compare the right child with left child in next condition
                maxIndexReference = leftIndex;
            }//if above parent is still greater then it will compare with parent 
                //index it self because it stil holds that data     
            if(rightIndex<curSize && heap.get(rightIndex)>heap.get(maxIndexReference)){
                maxIndexReference = rightIndex;
            }
            if(maxIndexReference!=index){
                swap(maxIndexReference,index);
                index = maxIndexReference;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        new KthLargestEle().findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
}
