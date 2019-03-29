//DFS traversal using Adjancency Matrix
/*
Sample input
4
3
0 2
2 1
1 3

Sample output
0
2
1
3
*/
import java.util.*;
public class MyClass {
    static void print(int[][] edges,int n,int sv,boolean[] visited)  //sv--starting vertex
    {
        System.out.println(sv);
        visited[sv]=true;
        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1&&visited[i]==false)
            {
                print(edges,n,i,visited);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        int[][] edges=new int[n][n];
        boolean[] visited=new boolean[n];   //visited nodes---initially all are false
        for(int i=0;i<e;i++)
        {
            int f=sc.nextInt();
            int s=sc.nextInt();
            edges[f][s]=1;
            edges[s][f]=1;
        }
        print(edges,n,0,visited);
      

    }
}
