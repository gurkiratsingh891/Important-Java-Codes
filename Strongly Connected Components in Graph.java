//Strongly Connected Components
/*
Sample Input1
6
7
1 2
2 3
3 4
4 1
3 5
5 6
6 5

Sample Output1
1 4 3 2 
5 6

Sample Input2
10
12
1 2
2 3
3 4
4 1
3 5
5 6
6 7
7 5
8 6
8 9
9 8
9 10

Sample Output2
8 9 
10 
1 4 3 2 
5 7 6 
*/
import java.util.*;
public class MyClass {
    static void dfs(ArrayList<Integer>[] edges,int element,boolean[] visited,Stack<Integer> finishedStack)
    {
        visited[element]=true;
        int size=edges[element].size();
        for(int i=0;i<size;i++)
        {
            int a=edges[element].get(i);
            if(visited[a]==false)
            {
                dfs(edges,a,visited,finishedStack);    
            }
        }
        finishedStack.push(element);
    }
    static void dfs1(ArrayList<Integer>[] edges,int element,boolean[] visited,ArrayList<Integer> component)
    {
        component.add(element);
        visited[element]=true;
        int size=edges[element].size();
        for(int i=0;i<size;i++)
        {
            int a=edges[element].get(i);
            if(visited[a]==false)
            {
                dfs1(edges,a,visited,component);
            }
        }
    }
    static void getSSC(ArrayList<Integer>[] edges,ArrayList<Integer>[] edgesT,int n,ArrayList<ArrayList<Integer>> list)
    {
        boolean[] visited=new boolean[n];
        Stack<Integer> finishedVertices=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                
                dfs(edges,i,visited,finishedVertices);
            }
        }
        Arrays.fill(visited,false);
        while(finishedVertices.empty()==false)
        {
            int element=finishedVertices.pop();
            if(visited[element]==false)
            {
                ArrayList<Integer> component=new ArrayList<Integer>();
                dfs1(edgesT,element,visited,component);
                list.add(component);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();   //number of vertices
        int e=sc.nextInt();   //number of edges
        ArrayList<Integer>[] edges=new ArrayList[n];
        ArrayList<Integer>[] edgesT=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            edges[i]=new ArrayList<Integer>();
            edgesT[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<e;i++)
        {
            int f=sc.nextInt()-1;
            int s=sc.nextInt()-1;
            edges[f].add(s);
            edgesT[s].add(f);
        }
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        getSSC(edges,edgesT,n,list);
        int size=list.size();
        for(int i=0;i<size;i++)
        {
            int n2=list.get(i).size();
            for(int j=0;j<n2;j++)
            {
                System.out.print(list.get(i).get(j)+1+" ");
            }
            System.out.println();
        }
    }
}
