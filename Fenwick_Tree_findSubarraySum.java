//Fenwick Tree
//Finding sum of Subarray (queries+updating elements)
import java.util.*;
public class MyClass {
    static void update(int index,int value,int[] bit,int n)
    {
        for(;index<=n;index+=index&(-index))
        {
            bit[index]+=value;
        }
    }
    static int query(int index,int[] bit)
    {
        int sum=0;
        for(;index>0;index-=index&(-index))
        {
            sum+=bit[index];
        }
        return sum;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();  //number of elements in array
        int arr[]=new int[n+1];
        int bit[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=sc.nextInt();
            update(i,arr[i],bit,n);
        }

        System.out.println("Sum of first 5 elements: "+query(5,bit));
        System.out.println("Sum of elements from index 2 to 6: "+(query(6,bit)-query(1,bit)));
    }
}
