/*
---------Split the array into equal sum parts according to given conditions----------
Given an integer array arr[], the task is to check if the input array can be split in two sub-arrays such that:

Sum of both the sub-arrays is equal.
All the elements which are divisible by 5 should be in the same group.
All the elements which are divisible by 3 (but not divisible by 5) should be in the other group.
Elements which are neither divisible by 5 nor by 3 can be put in any group.
If possible then print Yes else print No.

Input: arr[] = {1, 2}
Output: No
The elements cannot be divided in groups such that there sum is equal.

Input: arr[] = {1, 4, 3}
Output: Yes
{1, 3} and {4} are the groups satisfying the given condition.
*/
import java.util.*;
public class MyClass {
    static boolean helper(int[] arr,int n,int start,int lsum,int rsum)
    {
        if(start==n)
            return lsum==rsum;
        if(arr[start]%5==0)
            lsum+=arr[start];
        else if(arr[start]%3==0)
            rsum+=arr[start];
        else
        {
            return helper(arr,n,start+1,lsum+arr[start],rsum)||helper(arr,n,start+1,lsum,rsum+arr[start]);
        }
        return helper(arr,n,start+1,lsum,rsum);
    }
    static boolean splitArray(int[] arr,int n)
    {
        return helper(arr,n,0,0,0);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();   //number of elements of array
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(splitArray(arr,n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
