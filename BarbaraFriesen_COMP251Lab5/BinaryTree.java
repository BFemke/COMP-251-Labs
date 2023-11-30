/**
 * Name: Barbara Friesen
 * student number: 300184589
 * Date: Mar. 10, 2021
 * 
 * Implement two tests to demonstrate knowledge of binary trees.
 * Also implement post-order and pre-order printing and finding height.
 * Original notation kept for other methods
 */

package BarbaraFriesen_COMP251Lab5;

//BinaryNode class; stores a node in a tree.
//
//CONSTRUCTION: with (a) no parameters, or (b) an Object,
//  or (c) an Object, left child, and right child.
//
//*******************PUBLIC OPERATIONS**********************
//int size( )            --> Return size of subtree at node
//int height( )          --> Return height of subtree at node
//void printPostOrder( ) --> Print a postorder tree traversal
//void printInOrder( )   --> Print an inorder tree traversal
//void printPreOrder( )  --> Print a preorder tree traversal
//BinaryNode duplicate( )--> Return a duplicate tree

/**
* Binary node class with recursive routines to
* compute size and height.
*/
class BinaryNode<AnyType>
{
 private AnyType             item;
 private BinaryNode<AnyType> left;
 private BinaryNode<AnyType> right;
 
 public BinaryNode( ) {
     this( null, null, null );
 }
 
 public BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt ){
     item = theElement;
     left    = lt;
     right   = rt;
 }

 // access to fields
 public AnyType getElement( ) { return item; }
 public BinaryNode<AnyType> getLeft( ) { return left; }
 public BinaryNode<AnyType> getRight( ) { return right; }
 
 // change fields
 public void setElement( AnyType x ) { item = x; }
 public void setLeft( BinaryNode<AnyType> t ) { left = t; }
 public void setRight( BinaryNode<AnyType> t ) { right = t; }

 /**
  * Return the size of the binary tree rooted at t.
  * Note that the method is static, so we can call 
  * even before any object created.
  */
 public static <AnyType> int size( BinaryNode<AnyType> t )
 {
     if( t == null )
         return 0;
     else
         return 1 + size( t.left ) + size( t.right );
 }

 /**
  * Return the height of the binary tree rooted at t.
  */
 public static <AnyType> int height( BinaryNode<AnyType> t )
 {
 	if(t ==  null) {return 0;} //base case if tree empty
 	else {
 		return 1+ Math.max(height(t.left), height(t.right)); //recursively traverses left and right
 															 //and returns largest value
 	}
 }

 // Print tree rooted at current node using pre-order traversal.
 public void printPreOrder( )
 {
	 System.out.println( item );  //prints root first
	 if( left != null )
         left.printPreOrder( );	//then left
	 if( right != null )
         right.printPreOrder( );	//then right
 }


 // Print tree rooted at current node using post-order traversal.
 public void printPostOrder( )
 {
	 if( left != null )		
         left.printPostOrder( ); //prints left node first 
	 if( right != null )
         right.printPostOrder( ); //then right
	 System.out.println( item ); 	//lastly the root node
 }

 // Print tree rooted at current node using in-order traversal.
 public void printInOrder( )
 {
     if( left != null )
         left.printInOrder( );            // Left
     System.out.println( item );       // Node
     if( right != null )
         right.printInOrder( );           // Right
 }


 /**
  * Return a reference to a node that is the root of a
  * duplicate of the binary tree rooted at the current node.
  * In other words, create a copy of the tree rooted at
  * the current node.
  */
 public BinaryNode<AnyType> duplicate( )
 {
     BinaryNode<AnyType> root = new BinaryNode<AnyType>( item, null, null );

     if( left != null )            // If there's a left subtree
         root.left = left.duplicate( );    // Duplicate; attach
     if( right != null )          // If there's a right subtree
         root.right = right.duplicate( );  // Duplicate; attach
     return root;                      // Return resulting tree
 }

}



/* BinaryTree.java */
//// *** Fields ***


//BinaryTree class; stores a binary tree.
//
//CONSTRUCTION: with (a) no parameters or (b) an object to
//be placed in the root of a one-element tree.
//
//Author: Mark Allen Weiss
//*******************PUBLIC OPERATIONS**********************
//Various tree traversals, size, height, isEmpty, makeEmpty.
//Also, the following tricky method:
//void merge( Object root, BinaryTree t1, BinaryTree t2 )
//                  --> Construct a new tree
//*******************ERRORS*********************************
//Error message printed for illegal merges.

/**
* BinaryTree class that illustrates the calling of
* BinaryNode recursive routines and merge.
*/
public class BinaryTree<AnyType>
{
	private BinaryNode<AnyType> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree( AnyType rootItem ){
		root = new BinaryNode<AnyType>( rootItem, null, null );
	}

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public BinaryNode<AnyType> getRoot() {
		return root;
	}

/**
Returns the number of nodes in the tree.
Uses a recursive helper that recurs
down the tree and counts the nodes.
*/
	public int size() {
		return BinaryNode.size( root );
	}

/**
Returns the height (max root-to-leaf depth) of the tree.
Uses a recursive helper that recurs down to find
the height (max depth).
*/
	public int height() {
		
		return Math.max(BinaryNode.height(this.root), BinaryNode.height(this.root));
		
	}

	public void printPreOrder() {
		if( root != null )
			root.printPreOrder(); //calls print pre-order from BinaryNode class   
	}

	public void printInOrder(){
		if( root != null )
			root.printInOrder();
	}

	public void printPostOrder() {
		if( root != null )
			root.printPostOrder(); //calls print post-order from BinaryNode class   
	}

/**
* Merge routine for BinaryTree class.
* Forms a new tree from rootItem, t1 and t2.
* Does not allow t1 and t2 to be the same.
* Correctly handles other aliasing conditions.
*/
	public void merge( AnyType rootItem, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2 ) {
		if( t1.root == t2.root && t1.root != null ) {
			System.err.println( "leftTree==rightTree; merge aborted" );
			return;
		}

      // Allocate new node
		root = new BinaryNode<AnyType>( rootItem, t1.root, t2.root );

      // Ensure that every node is in just one tree!
		if( this != t1 )
			t1.root = null;
		if( this != t2 )
			t2.root = null;
	}


	static public void main( String [ ] args ) {
  
		test1();
		test2(); //minimum height
		test3(); //maximum height
	}

	private static void test1(){
		BinaryTree<Integer> t4 = new BinaryTree<Integer>( 4 );
		BinaryTree<Integer> t5 = new BinaryTree<Integer>( 5 );
		BinaryTree<Integer> t6 = new BinaryTree<Integer>( 6 );
		BinaryTree<Integer> t1 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t2 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t3 = new BinaryTree<Integer>( );
		BinaryTree<Integer> temp = new BinaryTree<Integer>( );
  
		t2.merge( 2, t4, t5 );
		t3.merge( 3, t6, temp );
		t1.merge( 1, t2, t3 );

		System.out.println( "t1 should be a tree with 6 nodes; t2 is empty" );
		System.out.println( "----------------" );
		System.out.println( "t1" );
		t1.printInOrder( );
		System.out.println( "----------------" );
		System.out.println( "t2" );
		t2.printInOrder( );
		System.out.println( "----------------" );
		System.out.println( "t1 size: " + t1.size() );
		System.out.println( "t1 height: " + t1.height() );
		System.out.println();
	}

	// create a tree with 7 nodes and minimum possible height
	private static void test2(){
		BinaryTree<Integer> t1 = new BinaryTree<Integer>(  );
		BinaryTree<Integer> t2 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t3 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t4 = new BinaryTree<Integer>( 5 );
		BinaryTree<Integer> t5 = new BinaryTree<Integer>( 1 );
		BinaryTree<Integer> t6 = new BinaryTree<Integer>( 3 );
		BinaryTree<Integer> t7 = new BinaryTree<Integer>( 9 );
		
		t3.merge(2, t4, t5);
		t2.merge( 4, t7, t6);
		t1.merge( 7, t3, t2);	
		
		System.out.println( "t1" );
		System.out.println( "-----InOrder----" );
		t1.printInOrder( );
		System.out.println( "----PreOrder----" );
		t1.printPreOrder( );
		System.out.println( "----PostOrder---" );
		t1.printPostOrder( );
		System.out.println( "----------------" );
		System.out.println( "t1 size: " + t1.size() );
		System.out.println( "t1 height: " + t1.height() );
		System.out.println();
	}
	// create a tree with 7 nodes and maximum possible height
	private static void test3(){
		BinaryTree<Integer> t1 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t2 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t3 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t4 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t5 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t6 = new BinaryTree<Integer>( );
		BinaryTree<Integer> t7 = new BinaryTree<Integer>( 9 );
		BinaryTree<Integer> temp = new BinaryTree<Integer>( );
		
		t1.merge(5, temp, t7);
		t2.merge(7, temp, t1);
		t3.merge(2, temp, t2);
		t4.merge(4, temp, t3);
		t5.merge(1, temp, t4);
		t6.merge(3, temp, t5);
		
		System.out.println( "t6 should be a tree with 7 nodes and max height." );
		System.out.println( "t6" );
		System.out.println( "----------------" );
		t6.printInOrder( );
		System.out.println( "----------------" );
		System.out.println( "t6 size: " + t6.size() );
		System.out.println( "t6 height: " + t6.height() );
	}
}
