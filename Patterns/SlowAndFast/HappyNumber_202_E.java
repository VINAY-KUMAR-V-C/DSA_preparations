// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.

package Patterns.SlowAndFast;

import java.util.HashSet;

class HappyNumber_202_E {
    public  static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        while(!set.contains(n)){
            set.add(n);
            String numToString = String.valueOf(n);
            int total = 0;
            for(char c: numToString.toCharArray()){
                int a = Character.getNumericValue(c);
                total += (a)*(a);
            }
            if(total==1){
                return true;
            }
            n = total;
        }
        return false;
    }
    public static void main(String[] args) {
        //not happy number
        isHappy(2);// 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 
        //happy number 
        isHappy(19);
    }
}