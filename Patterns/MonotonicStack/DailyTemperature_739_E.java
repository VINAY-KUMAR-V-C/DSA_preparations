package Patterns.MonotonicStack;

import java.util.Stack;

class DailyTemperature_739_E {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = temperatures.length-1;
        Stack<Integer> indexs = new Stack<>();
        int[] res = new int[i+1];
        while(i>=0){
            if(indexs.isEmpty()){
                res[i] = 0;
            }else{
                int cur = temperatures[i];
                while(!indexs.isEmpty() && cur>=temperatures[indexs.lastElement()]){
                    indexs.pop();
                }
                if(indexs.isEmpty()){
                    res[i] = 0;
                }else{
                    res[i] = indexs.lastElement()-i;
                }
            }
            indexs.add(i);
            i--;
        }
        return res;
    }
    public static void main(String[] args) {
        new DailyTemperature_739_E().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}