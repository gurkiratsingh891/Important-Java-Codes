//Trailing Zeros in Factorial
/*
Question of InterViewBit
https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
Sample Input
5
Sample Output
1
*/
import java.util.*;
public class MyClass {
    static int trailingZeroes(int A) {
        int count=0;
        int div=5;
        while(div<=A)
        {
            count=count+A/div;
            div=div*5;
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
        System.out.println(trailingZeroes(n));
    }
}
