package BarbaraFriesen_COMP251Lab2_Ex1;

public class SinglyLinkedList<E> 
{
	
	//Nested Node class
	private static class Node<E>
	{
		private E element;			//reference to element stored in node
		private Node<E> next;		//reference to subsequent not in list
		public Node(E e, Node<E> n)
		{
			element = e;
			next = n;
		}
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n ) {next = n;}
	}
	
	private Node<E> head = null; 		//First node in list
	private Node<E> tail = null;		//Last  node in list
	private int size = 0;				//number of nodes in list
	
	public SinglyLinkedList() {} //Constructs empty list
	
	//Getters
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first()
	{
		if(isEmpty()) return null;
		return head.getElement();
	}
	public E last()
	{
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	//Setters
	public void addFirst(E e)			//Adds new node to start of list
	{
		head = new Node<E>(e, head);	//creates new node with element e and linked to previous head
		if(size == 0) tail = head;		//head is also tail if list is empty
		size++;							
	}
	public void addLast(E e)						//Adds new node to back of list
	{
		Node<E> newest = new Node<E>(e, null);		//convenience variable to switch values
		if(isEmpty()) head = newest; 				//tail is also head if list is empty
		else tail.setNext(newest);					//sets reference to new tail to previous tail
		tail = newest;								//sets new node as tail
		size++;
	}
	public E removeFirst()					//removes first node in list
	{
		if(isEmpty()) return null;			
		E answer = head.getElement();		//convenience variable to help switch
		head = head.getNext();				//second node becomes first node
		size--;
		if(size == 0) tail = null;			//removes tail reference in the case there was only one element in the list
		return answer;
	}
	public void swapNodes(int num1, int num2)
	{
		if(num1 < 0 || num1 > size() || num2 < 0 || num2 > size())
		{
			System.out.println("Invalid nodes selected.");
			return;
		}
		Node<E> node1 = getNode(num1);		//Lets node1 equal the num1th node
		Node<E> node2 = getNode(num2);		//Lets node2 equal the num2th node
		if(node1.equals(node2))
		{
			System.out.println("The nodes are identical.");
			return;
		}
		Node<E> n1Next = node2.getNext(); 
		Node<E> n2Next = node1.getNext(); 
		
		//Handles all possible locations of the nodes for node 2 and sets next node
		if(num1 == 1)
		{
			node2.setNext(n2Next);
			head = node2;
		}
		else if(num1 == size())
		{
			node2.setNext(null);
			tail = node2;
			getNode(num1-1).setNext(node2);
		}
		else 
		{
			node2.setNext(n2Next);
			getNode(num1-1).setNext(node2);
			printList();
		}
		
		//Handles all possible locations for node1 and sets next node
		if(num2 == 1)
		{
			node1.setNext(n1Next);
			head = node1;
		}
		else if(num2 == size())
		{
			node1.setNext(null);
			tail = node1;
			getNode(num2-1).setNext(node1);
		}
		else 
		{
			node1.setNext(n1Next);
			getNode(num2-1).setNext(node1);
		}
	}
	
	//USes for loop to get the nth node
	public Node<E> getNode(int index)
	{
		Node<E> n = head;
		for(int i = 1; i < index; i++)
		{
			n = n.getNext();
		}
		return n;
	}
	
	//Uses for loop to print all the elements from the list in order
	public void printList()
	{
		Node<E> node = head;
		for(int i = 0; i < size(); i++)
		{
			System.out.println(node.getElement());
			System.out.println(node);
			node = node.getNext();
		}
	}
}
