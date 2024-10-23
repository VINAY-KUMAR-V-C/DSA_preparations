package Patterns.TopKEle;

public class MaxHeap {
    public int[] maxHeap;
    int curSize;

    public MaxHeap(int size) {
        maxHeap = new int[size];
        curSize = 0;
    }

    public void removeFirstIndex() {
        removeValue(0);
    }

    public void removeValue(int index) {
        if (index >= 0 && index < curSize) {
            maxHeap[index] = maxHeap[curSize - 1];
            curSize--;
            heapifyDown(index);
        }
    }

    private boolean isLeaf(int index) {
        return index >= maxHeap.length / 2 && index < curSize;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void heapifyDown(int index) {
        while (!isLeaf(index)) {
            int maxIndexReference = index;
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            // first check left child is greater
            if (leftIndex < curSize && maxHeap[leftIndex] > maxHeap[index]) {
                // if left child is greater ,
                // then compare the right child with left child in next condition
                maxIndexReference = leftIndex;
            } // if above parent is still greater then it will compare with parent
              // index it self because it stil holds that data
            if (rightIndex < curSize && maxHeap[rightIndex] > maxHeap[maxIndexReference]) {
                maxIndexReference = rightIndex;
            }
            if (maxIndexReference != index) {
                swap(maxIndexReference, index);
                index = maxIndexReference;
            } else {
                break;
            }
        }
    }

    public void insertValue(int value) {
        if (curSize > maxHeap.length) {
            return;
        }
        maxHeap[curSize++] = value;
        heapifyUp(curSize - 1);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int indexA, int indexB) {
        int temp = maxHeap[indexA];
        maxHeap[indexA] = maxHeap[indexB];
        maxHeap[indexB] = temp;
    }

    private void heapifyUp(int index){
        while(index>0 && maxHeap[index]>maxHeap[getParentIndex(index)]){
            swap(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }
}
