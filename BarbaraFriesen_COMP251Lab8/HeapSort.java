package BarbaraFriesen_COMP251Lab8;

import java.util.NoSuchElementException;

/**
 *Implementation of Max Heap .
 */
 class MaxHeap<AnyType extends Comparable<? super AnyType>>
{

    private static int INITSIZE = 100;

    private int currentSize;   // Number of elements in heap
    private AnyType [ ] array; // The heap array
    
        
    /**
     * Construct an empty MaxHeap.
     */
    public MaxHeap( )
    {
        currentSize = 0;
        array = (AnyType[]) new Comparable[ INITSIZE + 1 ];
    }
    
    
    /**
     * Inserts an item to this MaxHeap.
     * @param x any object.
     * @return true.
     */
    public boolean push( AnyType x )
    {
        //if the array is full expand it
        if( currentSize + 1 == array.length )
            expandArray( );

            // Percolate up
        int hole = ++currentSize;
        array[ 0 ] = x;

        for( ; x.compareTo(array[ hole / 2 ] ) > 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
        
        return true;
    }
    
    /**
     *  isEmpty() indicates whether the heap is empty.
         *  @return true if the list is empty, false otherwise.
         **/

    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /**
     * Returns the number of items in this MaxHeap.
     * @return the number of items in this MaxHeap.
     */
    public int size( )
    {
        return currentSize;
    }
    
    /**
     * Make this MaxHeap empty.
     */
    public void clear( )
    {
        currentSize = 0;
    }
    
    /**
     * Returns the smallest item in the MaxHeap.
     * @return the smallest item.
     * @throws NoSuchElementException if empty.
     */
    public AnyType top( )
    {   
        if( isEmpty( ) )
            throw new NoSuchElementException();
        return array[ 1 ];
    }
    
    /**
     * Removes the largest item in the MaxHeap.
     * @return the largest item.
     * @throws NoSuchElementException if empty.
     */
    public AnyType pop( )
    {
        AnyType minItem = top( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }


    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    public void buildHeap( )
    {   
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }


    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */

    private void percolateDown( int hole )
    {
        int child;
        //store data at index hole in variable temp
        AnyType tmp = array[ hole ];
        /*while the child of hole is less than current size of heap*/
        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].compareTo(array[ child ] ) > 0 )
                child++;
            if( array[ child ].compareTo(tmp ) > 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        //assign index hole as temp
        array[ hole ] = tmp;
    }
    
    /**
         *  expandArray(): internal method to extend array.
         *  creates a new array with larger size (twice)
         */
     private void expandArray() {
        AnyType [ ] newArray;

        newArray = (AnyType []) new Comparable[ array.length * 2 ];
        for( int i = 0; i < array.length; i++ )
            newArray[ i ] = array[ i ];
        array = newArray;
    }
    
   
}
public class HeapSort{

    public static void main( String [ ] args )
    {
        MaxHeap<Integer> maxheap = new MaxHeap<Integer>( );
        int array[]={5,3,9,7,2,4,6,1,8};
        
      //Inputs elements into max heap one by one
        System.out.println("Array before max heap sort:");
        for(int i=0;i<9;i++){
            maxheap.push(array[i]);
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        
        //Prints out element in max heap 
        System.out.println("Array after max heap sort:");
        while(!maxheap.isEmpty()){
            System.out.print(maxheap.pop()+" ");
            
        }
        System.out.println();
    }
}
