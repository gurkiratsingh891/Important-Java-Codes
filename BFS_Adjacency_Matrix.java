//BFS traversal using Adjancency Matrix
/*
Sample input
4 4
0 1
0 3
1 2
2 3

Sample output
0 
1
3
2
*/
import java.util.*;
public class MyClass {
    static void print(int[][] edges,int n,boolean[] visited,Queue<Integer> que)  
    {
        if(que.peek()==null)
        return;
        int sv=que.remove();
        System.out.println(sv);
        
        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1&&visited[i]==false)
            {
                que.add(i);
                visited[i]=true;

            }
        }
        print(edges,n,visited,que);
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
                Queue<Integer> que=new LinkedList<Integer>();
            que.add(0);
            visited[0]=true;
        print(edges,n,visited,que);
      

    }
}
