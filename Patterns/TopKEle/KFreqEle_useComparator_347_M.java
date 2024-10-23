package Patterns.TopKEle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Q : 1,1,1,2,2,3   k = 2 
//A : 1,2
//Q : 1,1,12,3,3   k = 2
//A : 1,3
//not valid question
//Q : 1,1,12,3,3   k = 1
public class KFreqEle_useComparator_347_M {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> valToFreq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            valToFreq.put(nums[i],valToFreq.getOrDefault(nums[i], 0)+1);
        }
        List<Node> list = new ArrayList<>();
        for(Integer key:valToFreq.keySet()){
            list.add(new Node(valToFreq.get(key),key));
        }
        list.sort(new SortByFreq());
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = list.get(i).val;
        }
        return res;
    }
    class Node{
        int freq;
        int val;
        Node(int freq,int val){
            this.freq = freq;
            this.val = val;
        }
    }
    class SortByFreq implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.freq-o1.freq;
        }
    }
}
