//Fast IO using Bufferreader Class
// Program to read elements from console and print them
import java.io.*;
import java.util.*;
public class MyClass {
    public static void main(String args[]) throws Exception {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int n= Integer.parseInt(inp.readLine());  // number of elements
        int arr[]=new int[n];
        String[] s1 = inp.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(s1[i]);
        }
            System.out.println(Arrays.toString(arr));
    }
}
