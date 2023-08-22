package Problems;

public class StepsProblem_1_2{
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        n = n-2;
        while(n>0){
            n--;
            b = a+b;
            a = b-a;
        }
        return b;
    }
}
