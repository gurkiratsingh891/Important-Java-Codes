//maximum sum subarray
/*
Sample Input
5
10 -5 6 7 -4
Sample Output
18
*/
import java.util.*;
public class MyClass {
    static int kadane(int[] arr)   //Using KADANE Algorithm
    {
        int current=0;
        int best=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            current+=arr[i];
            if(best<current)
            best=current;
            if(current<0)
            current=0;
        }
        return best;
    }
    public static void main(String args[]) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();    //number of elements
     int[] arr=new int[n];
     for(int i=0;i<n;i++)
     {
         arr[i]=sc.nextInt();    //Array elements
     }
     System.out.println(kadane(arr));
     
    }
}
