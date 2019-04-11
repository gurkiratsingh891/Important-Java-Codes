//Max Non Negative Subarray
/*
Sample Input
6
1 2 5 -7 2 3
Sample output
1 2 5
*/
import java.util.*;
public class Solution {
    static int[] maxset(int[] A) {
        int n=A.length;
            int l=0;int h=0;
        long max=0;
        long sum=0;
        int left=0;
        int right=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            if(A[i]<0)
            {
                right=i+1;
                left=i+1;
                sum=0;
            }
            else
            {
                sum+=A[i];
                flag=true;
                right=i;
                 if(max<sum||(max==sum&&h-l<right-left))
                {
                    max=sum;
                    l=left;
                    h=right;
                }
            }
        }
        if(flag==false)
        return new int[0];
        int[] arr=new int[h-l+1];
        for(int i=l;i<=h;i++)
        {
            arr[i-l]=A[i];
        }
        return arr;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //number of elements
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int res[]=maxset(arr);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
}
