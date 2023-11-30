package BarbaraFriesen_COMP251Lab2_Ex2;

public class DoublyLinkedList<E> {
		
	private static class Node<E>
	{
		private E element;			//references element stored in node
		private Node<E> prev;		//references previous node in list
		private Node<E> next;		//references next node in list
		
		public Node(E e, Node<E> p, Node<E> n) 		//Constructs node
		{
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getPrev() {return prev;}
		public Node<E> getNext() {return next;}
		public void setPrev(Node<E> p) {prev = p;}
		public void setNext(Node<E> n) {next = n;}
	}
	
	private Node<E> header;			//header sentinel
	private Node<E> trailer;		//trailer sentinel
	private int size = 0;
	
	public DoublyLinkedList()  						//Creates new empty list
	{
		header = new Node<>(null, null, null);		//creates header
		trailer = new Node<>(null, header, null);	//creates trailer with header preceding
		header.setNext(trailer);					//sets trailer as next for header
	}
	
	//Getters
	public int size() {return size;}				//Returns size of list	
	public boolean isEmpty() {return size == 0;}	//Tests whether list empty or not
	public E first() 								//returns element of first node
	{
		if(isEmpty()) return null;					
		return header.getNext().getElement();		//first element is after header
	}
	public E last()									//returns element of last node
	{
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();		//last element is before trailer
	}
	
	//Setters
	public void addFirst(E e)						//adds node to beginning of list
	{
		addBetween(e, header, header.getNext());	//places node just after header
	}
	public void addLast(E e)						//adds node at end of list
	{
		addBetween(e, trailer.getPrev(), trailer);	//places node just before trailer
	}
	public E removeFirst()							//removes first node
	{
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	public E removeLast()							//removes last node
	{
		if(isEmpty()) return null;					
		return remove(trailer.getPrev());
	}
	
	//Private update methods
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) //adds element between two nodes
	{
		//establishes dual link
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	private E remove(Node<E> node)				//removes node from list returning element
	{
		//links next and previous nodes together
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	
	
	//Links two lists into the first list parameter
	public void linkLists(DoublyLinkedList<E> L, DoublyLinkedList<E> M)
	{
		int sizeM = M.size();
		
		//Copies over beginning of list M to back of list L, deleting node in M after copy
		for(int i = 0; i < sizeM; i++)
		{
			L.addLast(M.first());
			M.removeFirst();
		}
	}
	
	//Prints elements of list in order
	public void printList()
	{
		Node<E> node = header.getNext();
		for(int i = 0; i < size(); i++)
		{
			System.out.println(node.getElement());
			node = node.getNext();
		}
	}
}
