//Checking whether a graph is bipartite or not
//This program works for connected graphs only
/*
Sample Input 1
5 5
0 1
1 2
2 3
3 4
4 0
Sample output1 --Not Bipartite graph
Sample Input2
4 4
0 1
1 2
2 3
3 0
Sample Output2-- Bipartite graph
*/
import java.util.*;
public class MyClass {
    static boolean bipartite(ArrayList<Integer>[] edges,int n)
    {
        ArrayList<HashSet<Integer>> set =new ArrayList<HashSet<Integer>>();
        set.add(new HashSet<Integer>());
        set.add(new HashSet<Integer>());
        Queue<Integer> pending =new LinkedList<Integer>();
        pending.add(0);
        set.get(0).add(0);
        while(!pending.isEmpty())
        {
            int element=pending.remove();
            int a=1; int b=0;
            if(set.get(0).contains(element))
            {
                a=0;
                b=1;
            }
            for(int i=0;i<edges[element].size();i++)
            {
                int neighbor=edges[element].get(i);
                if(set.get(0).contains(neighbor)==false && set.get(1).contains(neighbor)==false)
                {
                    set.get(b).add(neighbor);
                    pending.add(neighbor);
                }
                else if(set.get(a).contains(neighbor))
                {
                    return false;
                }
            }
        }
        return true;
    } 
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();  //number of vertices
        int e=sc.nextInt();  //number of edges
        ArrayList<Integer>[] edges=new ArrayList[n];
        for(int i=0;i<n;i++)
            edges[i]=new ArrayList<Integer>();
        for(int i=0;i<e;i++)
        {
            int f=sc.nextInt();
            int s=sc.nextInt();
            edges[f].add(s);
        }
        if(bipartite(edges,n))
            System.out.println("Bipartite graph");
        else
            System.out.println("Not Bipartite graph");
        
    }
}
