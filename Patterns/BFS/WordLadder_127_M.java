import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_127_M {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordList);
        traverse(beginWord, set, endWord, 1,map);
        return (minCount==Integer.MAX_VALUE)?0:minCount;
    }
    int minCount = Integer.MAX_VALUE;
    public void traverse(String curWord,Set<String> remain,String endWord,int curCount,HashMap<String,Integer> map){
        if(minCount<curCount){
            return ;
        }else{
            curCount++;
            for(int i=0;i<curWord.length();i++){
                for(char j='a';j<='z';j++){
                    String s = curWord.substring(0,i)+String.valueOf(j)+curWord.substring(i+1);
                    if(remain.contains(s)){
                        if(s.equals(endWord)){
                            minCount = Math.min(curCount, minCount);
                            return ;
                        }
                        Set<String> copyRemain = new HashSet<>(remain);
                        copyRemain.remove(s);
                        traverse(s, copyRemain, endWord, curCount,map);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        int res = new WordLadder_127_M().ladderLength("hit","cog",list);
        System.out.println(res);
    }
}
