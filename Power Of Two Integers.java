/*
Power of two Integers
InterView Bit Question
https://www.interviewbit.com/problems/power-of-two-integers/
Given a positive integer which fits in a 32 bit signed integer,
find if it can be expressed as A^P where P > 1 and A > 0. 
A and P both should be integers.
Sample Input
27
Sample Output
true;
*/
import java.util.*;
public class MyClass {
     static int isPower(int A) {
        if(A==1)
        return 1;
        for(int i=2;i<31;i++)
        {
            long max=Integer.MAX_VALUE;
            int j=2;
            long temp=(long)Math.pow(j,i);
            while(temp<=max)
            {
                if(temp==A)
                return 1;
                j++;
                temp=(long)Math.pow(j,i);
            }
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=isPower(n);
        if(res==1)
        System.out.println(true);
        else
        System.out.println(false);

    }
}
