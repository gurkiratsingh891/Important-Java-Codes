//ZigZag Tree
/*
Given a Binary Tree, print the zig zag order i.e peinr level 1 from left to right, level 2
from right to left and so on. This means odd levels should get printed from left to right and 
even level from right to left.

Sample Input
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

Sample Output
1 
3 2 
4 5 6 7 
15 14 13 12 11 10 9 8 
*/

import java.util.*;

class Solution
{
    static void print(Queue<BinaryTreeNode> que)
    {
        if(que.isEmpty())
        return;
        Queue<BinaryTreeNode> newque=new LinkedList<BinaryTreeNode>();
        while(!que.isEmpty())
        {
            BinaryTreeNode node=que.remove();
            System.out.print(node.data+" ");
            if(node.left!=null)
            newque.add(node.left);
            if(node.right!=null)
            newque.add(node.right);
        }
        System.out.println();
        revprint(newque);
    }
    static void revprint(Queue<BinaryTreeNode> que)
    {
        if(que.isEmpty())
        return;
        Stack<Integer> stk=new Stack<Integer>();
        Queue<BinaryTreeNode> newque=new LinkedList<BinaryTreeNode>();
        while(!que.isEmpty())
        {
            BinaryTreeNode node=que.remove();
            stk.push((int)node.data);
             if(node.left!=null)
            newque.add(node.left);
            if(node.right!=null)
            newque.add(node.right);
        }
        while(!stk.empty())
        {
            System.out.print(stk.pop()+" ");
        }
        System.out.println();
        print(newque);
    }
    static void printZigZag(BinaryTreeNode root)
    {
        Queue<BinaryTreeNode> que=new LinkedList<BinaryTreeNode>();
        que.add(root);
        print(que);
    }
}

class QueueEmptyException extends Exception {
}

class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
}

class QueueUsingLL<T> {


	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class Main {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		Solution.printZigZag(root);
	}
}
 
