//TODO:
//  (1) Update this code to meet the style and JavaDoc requirements.
//			Why? So that you get experience with the code for a heap!
//			Also, this happens a lot in industry (updating old code
//			to meet your new standards). We've done this for you in
//			WeissCollection and WeissAbstractCollection.
//  (2) Implement getIndex() method and the related map integration
//			 -- see project description
//  (3) Implement update() method -- see project description
//  (4) Other methods may also need to be updated to integrate with the map

import java.util.Iterator;
import java.util.Comparator;
import java.util.NoSuchElementException;

//You may use the JCF HashMap or the ThreeTenHashTable from Project 3.
//To use the JCF class, uncomment this line:
import java.util.HashMap;


//To use your code, just copy over ThreeTenHashTable from Project 3
//and DON'T uncomment the line above.
//You will need to make it a private class and
//may need to change the class name to use it here.

/**
 * PriorityQueue class implemented via the binary heap.
 * From your textbook (Weiss)
 */
public class WeissPriorityQueue<AnyType> extends WeissAbstractCollection<AnyType>
{

	//you may not have any other class variables, only this one
	//if you make more class variables your priority queue class
	//will receive a 0, no matter how well it works
	private static final int DEFAULT_CAPACITY = 100;

	//you may not have any other instance variables, only these four
	//if you make more instance variables your priority queue class
	//will receive a 0, no matter how well it works
	private int currentSize;   // Number of elements in heap
	private AnyType [ ] array; // The heap array
	private Comparator<? super AnyType> cmp;
	private HashMap<AnyType, Integer> indexMap = new HashMap<>(); ; //JCF or your class
	public static Comparator<GraphNode> comp2 = new Comparator<>() {
		public int compare(GraphNode s1, GraphNode s2) {
			//System.out.println("----------------------Queue is in to reorder: between: "+s1.getId()+" and "+s2.getId());

			int costCompare = Integer.compare(s1.getCost(), s2.getCost());
			if (costCompare == 0) {
				return Integer.compare(s1.getId(), s2.getId());
			}
			return costCompare;
		}
	};
	//--------------------------------------------------------
	// testing code goes here... edit this as much as you want!
	//--------------------------------------------------------

	public static void main(String[] args) {
		class Student {
			String gnum;
			String name;
			Student(String gnum, String name) { this.gnum = gnum; this.name = name; }
			public boolean equals(Object o) {
				if(o instanceof Student) return this.gnum.equals(((Student)o).gnum);
				return false;
			}
			public String toString() { return name + "(" + gnum + ")"; }
			public int hashCode() { return gnum.hashCode(); }
		}

		Comparator<Student> comp = new Comparator<>() {
			public int compare(Student s1, Student s2) {
				return s1.name.compareTo(s2.name);
			}

		};



		//TESTS FOR INDEXING -- you'll need more testing...

		WeissPriorityQueue<Student> q = new WeissPriorityQueue<>(comp);
		q.add(new Student("G00000000", "Robert"));
		System.out.print(q.getIndex(new Student("G00000001", "Cindi")) + " "); //-1, no index
		System.out.print(q.getIndex(new Student("G00000000", "Robert")) + " "); //1, at root
		System.out.println();

		q.add(new Student("G00000001", "Cindi"));
		System.out.print(q.getIndex(new Student("G00000001", "Cindi")) + " "); //1, at root
		System.out.print(q.getIndex(new Student("G00000000", "Robert")) + " "); //2, lower down
		System.out.println();

		q.remove(); //remove Cindi
		System.out.print(q.getIndex(new Student("G00000001", "Cindi")) + " "); //-1, no index
		System.out.print(q.getIndex(new Student("G00000000", "Robert")) + " "); //1, at root
		System.out.println();
		System.out.println();


		//TESTS FOR UPDATING -- you'll need more testing...

		q = new WeissPriorityQueue<>(comp);
		Student s1 = new Student("G00000000", "Robert");
		q.add(s1);
		Student s2 = new Student("G00000001", "Cindi");
		q.add(s2);

		for(Student s : q) System.out.print(q.getIndex(s) + " "); //1 2
		System.out.println();
		for(Student s : q) System.out.print(s.name + " "); //Cindi Robert
		System.out.println();

		s1.name = "Bobby";
		q.update(s1);

		for(Student s : q) System.out.print(q.getIndex(s) + " "); //1 2
		System.out.println();
		for(Student s : q) System.out.print(s.name + " ");  //Bobby Cindi
		System.out.println();

		s1.name = "Robert";
		q.update(s1);

		for(Student s : q) System.out.print(q.getIndex(s) + " "); //1 2
		System.out.println();
		for(Student s : q) System.out.print(s.name + " "); //Cindi Robert
		System.out.println();

		//you'll need more testing...
	}

	//--------------------------------------------------------
	// end of testing code
	//--------------------------------------------------------

	//you implement this
	public int getIndex(AnyType x) {
		// average case O(1)

		// returns the index of item x in the heap,
		// or -1 if it isn't in the heap
		Integer index = indexMap.get((GraphNode)x);
		if (index == null) {
			return -1;
		} else {
			return index;
		}
	}

	//you implement this
	public boolean update(AnyType x) {
		// Find the current location of x in the heap
		Integer index = getIndex(x);
		if (index == -1) {
			return false; // x is not in the heap
		}

		// Update the priority of x
		percolateDown(index);
		percolateUp(index);


		return true;
	}


	/**
	 * Construct an empty PriorityQueue.
	 */
	@SuppressWarnings("unchecked")
	public WeissPriorityQueue( )
	{
		currentSize = 0;
		cmp = null;
		array = (AnyType[]) new Object[ DEFAULT_CAPACITY + 1 ];
	}

	/**
	 * Construct an empty PriorityQueue with a specified comparator.
	 */
	@SuppressWarnings("unchecked")
	public WeissPriorityQueue( Comparator<? super AnyType> c )
	{
		currentSize = 0;
		cmp = c;
		array = (AnyType[]) new Object[ DEFAULT_CAPACITY + 1 ];
	}


	/**
	 * Construct a PriorityQueue from another Collection.
	 */
	@SuppressWarnings("unchecked")
	public WeissPriorityQueue( WeissCollection<? extends AnyType> coll )
	{
		cmp = null;
		currentSize = coll.size( );
		array = (AnyType[]) new Object[ ( currentSize + 2 ) * 11 / 10 ];

		int i = 1;
		for( AnyType item : coll )
			array[ i++ ] = item;
		buildHeap( );
	}

	/**
	 * Compares lhs and rhs using comparator if
	 * provided by cmp, or the default comparator.
	 */
	@SuppressWarnings("unchecked")
	private int compare( AnyType lhs, AnyType rhs )
	{
		if( cmp == null )
			return ((Comparable)lhs).compareTo( rhs );
		else
			return cmp.compare( lhs, rhs );
	}

	/**
	 * Adds an item to this PriorityQueue.
	 * @param x any object.
	 * @return true.
	 */
	public boolean add( AnyType x )
	{
		if( currentSize + 1 == array.length )
			doubleArray( );

		// Percolate up
		int hole = ++currentSize;
		array[ 0 ] = x;

		indexMap.put(x, hole); // Add x and its index to the indexMap
		for( ; comp2.compare((GraphNode)x ,(GraphNode) array[ hole / 2 ] ) < 0; hole /= 2 ) {
			array[ hole ] = array[ hole / 2 ];
			indexMap.put((AnyType)array[hole], hole); // Update the index of the parent in the indexMap

		}

		array[ hole ] = x;

		return true;
	}

	/**
	 * Returns the number of items in this PriorityQueue.
	 * @return the number of items in this PriorityQueue.
	 */
	public int size( )
	{
		return currentSize;
	}

	/**
	 * Make this PriorityQueue empty.
	 */
	public void clear( )
	{
		currentSize = 0;
	}

	/**
	 * Returns an iterator over the elements in this PriorityQueue.
	 * The iterator does not view the elements in any particular order.
	 */
	public Iterator<AnyType> iterator( )
	{
		return new Iterator<AnyType>( )
		{
			int current = 0;

			public boolean hasNext( )
			{
				return current != size( );
			}

			@SuppressWarnings("unchecked")
			public AnyType next( )
			{
				if( hasNext( ) )
					return array[ ++current ];
				else
					throw new NoSuchElementException( );
			}

			public void remove( )
			{
				throw new UnsupportedOperationException( );
			}
		};
	}

	/**
	 * Returns the smallest item in the priority queue.
	 * @return the smallest item.
	 * @throws NoSuchElementException if empty.
	 */
	public AnyType element( )
	{
		if( isEmpty( ) )
			throw new NoSuchElementException( );
		return array[ 1 ];
	}

	/**
	 * Removes the smallest item in the priority queue.
	 * @return the smallest item.
	 * @throws NoSuchElementException if empty.
	 */
	public AnyType remove( )
	{
		AnyType minItem = element( );
		array[ 1 ] = array[ currentSize-- ];
		percolateDown( 1 );


		return minItem;
	}


	/**
	 * Establish heap order property from an arbitrary
	 * arrangement of items. Runs in linear time.
	 */
	private void buildHeap( )
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
          //  System.out.println("--------------------------------down");
		int child;
		AnyType tmp = array[ hole ];

		for( ; hole * 2 <= currentSize; hole = child )
		{
			child = hole * 2;
			if( child != currentSize &&
					compare( array[ child + 1 ], array[ child ] ) < 0 )
				child++;
			if( compare( array[ child ], tmp ) < 0 ) {
				array[ hole ] = array[ child ];
			}
			else
				break;
		}
		array[ hole ] = tmp;
	}

	private void percolateUp(int hole) {
                   //     System.out.println("--------------------------------up");

		AnyType x = array[hole];
		int parent = hole / 2;
		while (parent > 0 && comp2.compare((GraphNode)x, (GraphNode)array[parent]) < 0) {
			array[hole] = array[parent];
			indexMap.put(array[hole], hole);
			hole = parent;
			parent = hole / 2;
		}
		array[hole] = x;
		indexMap.put(x, hole);
	}

	/**
	 * Internal method to extend array.
	 */
	@SuppressWarnings("unchecked")
	private void doubleArray( )
	{
		AnyType [ ] newArray;

		newArray = (AnyType []) new Object[ array.length * 2 ];
		for( int i = 0; i < array.length; i++ )
			newArray[ i ] = array[ i ];
		array = newArray;
	}
}
