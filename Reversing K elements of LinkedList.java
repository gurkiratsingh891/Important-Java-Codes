//reversing k elements of a linklist
/*
---Sample Input---
10
1 2 3 4 5 6 7 8 9 10
4
---Sample output---
4 3 2 1 8 7 6 5 10 9
*/
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        next=null;
        this.data=data;
    }
}
public class MyClass {
    static Node reverseK(Node head,int k)
    {
        if(k==1||k==0)
        return head;
        Node previous=null;
        Node current=head;
        Node forward;
        while(k>0)
        {
            forward=current.next;
            current.next=previous;
            previous=current;
            current=forward;
            k--;
        }
        head.next=current;
        return previous;
    }
  
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();   //number of elements in linkedlist
        Node head=new Node(sc.nextInt());
        Node copy=head;
        for(int i=1;i<n;i++)
        {
            Node temp=new Node(sc.nextInt());
            copy.next=temp;
            copy=temp;
        }
        int k=sc.nextInt();
       //copy=head;
        head=reverseK(head,k);
        copy=head;
        int count=n-k;
        while(k>1&&count>0)
        {
         Node temp=head;
        for(int i=0;i<k;i++)
        {
            temp=head;
            head=head.next;
        }
        int a=Math.min(count,k);
        head=reverseK(head,a);
        temp.next=head;
        count=count-k;
        }
 
        head=copy;
        while(copy!=null)
        {
            System.out.print(copy.data+" ");
            copy=copy.next;
        }
    }
}
