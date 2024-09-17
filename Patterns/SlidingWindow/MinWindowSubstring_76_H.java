package Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

class MinWindowSubstring_76_H {
    static String minWindow(String s ,String p){
        String res = s;
        boolean isResFound = false;
        int sLen = s.length();
        int pLen = p.length();
        if (pLen>sLen){
            return "";
        }
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashSet<Character> charToSatisfyP = new HashSet<>();
        for(int i=0;i<pLen;i++){
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
            charToSatisfyP.add(p.charAt(i));
        }
        while(end<sLen){
            char curChar = s.charAt(end);
            sMap.put(curChar,sMap.getOrDefault(curChar,0)+1);
            if(charToSatisfyP.contains(curChar) && sMap.get(curChar) >= pMap.get(curChar)){
                charToSatisfyP.remove(curChar);
            }
            if(charToSatisfyP.isEmpty()){
                while (start<=end){
                    isResFound = true;
                    res = res.length()<=s.substring(start, end+1).length()?res:s.substring(start, end+1);
                    char curStartChar = s.charAt(start);
                    if((!pMap.containsKey(curStartChar) && sMap.getOrDefault(curStartChar, 0)>0) ||( pMap.containsKey(curStartChar) && (sMap.get(curStartChar)-1 >= pMap.get(curStartChar)))){
                        sMap.put(curStartChar,sMap.get(curStartChar)-1);
                        start++;
                    }else{
                        break;
                    }
                }
            }
            end++;
        }
        return isResFound?res:"" ;
    }

    public static void main(String[] args) {
        minWindow("a","b");
        //minWindow("ADOBECODEBANC","ABC");
    }
}