// k-subset sum
//Given a set of n integers, find if a subset of sum k can be formed from the given set. Print Yes or No.
/*
Input Format
First line contains a single integer n (1<=n<=1000)
Second line contains n space separated integers (1<=a[i]<=1000)
Last line contains a single positive integer k (1<=k<=1000)
Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Sample Input
3
1 2 3
4
Sample Output
YES
*/
import java.util.Scanner;

public class Main {

	static boolean subset(int[] arr,int k,int i,int[][] dp)
    {
      if(k<0)
        return false;
      if(k==0)
        return true;
      if(i>=arr.length)
        return false;
      if(dp[i][k]!=0)
      {
        if(dp[i][k]==1)
          return true;
        else
          return false;
      }
      
      boolean a=subset(arr,k-arr[i],i+1,dp);
      if(a==true)
      {
        dp[i][k]=1;
        return true;
      }
      boolean b=subset(arr,k,i+1,dp);
      if(b==true)
      {
        dp[i][k]=1;
        return true;
      }
      dp[i][k]=2;
      return false;
    }
	public static void main(String[] args) {
		// Write your code here
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int[] arr=new int[n];
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
      }
      int k=sc.nextInt();
 		int[][] dp=new int[n][k+1];
		boolean a=subset(arr,k,0,dp);
      if(a==true)
        System.out.println("Yes");
      else
        System.out.println("No");
      
	}

}
