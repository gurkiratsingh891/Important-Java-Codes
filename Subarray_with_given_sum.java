//Subarray with given sum
/*
It is a question of Geeks for Geeks
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
Sample Input
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Sample Output
2 4
1 5
*/
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 for(int i=0;i<t;i++)
	 {
	    int n=sc.nextInt();
	    int s=sc.nextInt();
	    int[] arr=new int[n];
	    for(int j=0;j<n;j++)
	    {
	        arr[j]=sc.nextInt();
	    }
	    int l=0;
	   int sum=0;
	   int j=0;
	   int flag=1;
	    while(j<n)
	    {
	       sum+=arr[j];
	        j++;
	       while(l<n&&sum>s)
	       {
	           sum-=arr[l];
	           l++;
	       }
	        if(sum==s)
	        {
	            flag=0;
	            break;
	        }
	    }
	    if(flag==0)
	    System.out.println((l+1)+" "+j);
	    else
	    System.out.println(-1);
	 }
}}