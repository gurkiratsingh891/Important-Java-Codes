/*
Input:
1
8
the a there answer any by bye their
the
Output:
1
*/


import java.util.*;
import java.io.*;

class Node
{
    boolean isEndofword;
    Node[] children=new Node[26];
    
    Node()
    {
        isEndofword=false;
        for(int i=0;i<26;i++)
        {
            children[i]=null;
        }
    }
}
class GFG
 {
     static void insert(Node root,String s)
     {
         int len=s.length();
         for(int i=0;i<len;i++)
         {
             int index=s.charAt(i)-'a';
             if(root.children[index]==null)
             {
                 root.children[index]=new Node();
             }
             root=root.children[index];
         }
         root.isEndofword=true;
         
     }
     static boolean search(Node root,String s)
     {
         int len=s.length();
         for(int i=0;i<len;i++)
         {
             int index=s.charAt(i)-'a';
             if(root.children[index]==null)
             return false;
             root=root.children[index];
         }
         return root.isEndofword;
     }
	public static void main (String[] args) throws Exception
	 {
	 Scanner sc=new Scanner(System.in);
	 BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
	 //int t=sc.nextInt();
	 int t=Integer.parseInt(inp.readLine());
	 for(int i=0;i<t;i++)
	 {
	    int n=Integer.parseInt(inp.readLine());
	    String s[]=inp.readLine().split(" ");
	    Node root=new Node();
	    for(int j=0;j<n;j++)
	    {
	        insert(root,s[j]);
	    }
	    String str=inp.readLine();
	    if(search(root,str))
	    System.out.println(1);
	    else
	    System.out.println(0);
	    
	 
	 }
	}
}
