package BarbaraFriesen_COMP251Lab2_Ex2;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<String> L = new DoublyLinkedList<>();
		DoublyLinkedList<String> M = new DoublyLinkedList<>();
		
		String listL[] = new String[] {"One", "Two", "Three", "Four"};
		String listM[] = new String[] {"Five", "Six", "Seven", "Eight"};
		
		//Creates list L using array listL contents
		for(int i = 0; i < listL.length; i++)
		{
			L.addLast(listL[i]);
		}
		
		//Creates list M using array listM contents
		for(int i = 0; i < listM.length;i++)
		{
			M.addLast(listM[i]);
		}
		
		//Prints out individual list contents
		System.out.println("Contents of list L: ");
		L.printList();
		System.out.println("\nContents of List M: ");
		M.printList();
		
		L.linkLists(L, M);
		
		//Prints out new combined list contents
		System.out.println("\nNew contents of combined lists: ");
		L.printList();
		

	}

}
