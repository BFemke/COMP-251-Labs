package BarbaraFriesen_COMP251Lab2_Ex1;

public class Main {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> L = new SinglyLinkedList<>();
		
		int list[] = new int[] {1, 2, 3, 4, 5, 6};
		for(int i = 0; i < list.length; i++)
		{
			L.addLast(list[i]);
		}
		
		L.printList();
		System.out.println();
		L.swapNodes(1, 5);
		L.printList();

	}

}
