package Patterns.BackTracking;

import java.util.ArrayList;
import java.util.List;

class Permutation_46_M {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i :nums){
            list.add(i);
        }
        traverse(list, finalList, new ArrayList<>(),0);
        return finalList;
    }

    public void traverse(List<Integer> list,List<List<Integer>> finaList,List<Integer> currentList,Integer index ){
        int size = list.size();
        if (size==0){
            finaList.add(currentList);
        }else{
            for(int i=0;i<size;i++){
                List<Integer> currentListCopy = new ArrayList<>(currentList);
                currentListCopy.add(list.get(i));
                List<Integer> listCopy = new ArrayList<>(list);
                listCopy.remove(i);
                traverse(listCopy, finaList, currentListCopy, index);
            }
        }
    }
}