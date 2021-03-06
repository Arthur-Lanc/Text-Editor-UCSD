/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
//		assertEquals("Remove: check element is correct ", list1.head, list1.getNode(0).prev);
		try {
			list1.remove(-1);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			list1.remove(2);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		boolean a = list1.add(44);
		assertEquals("add: check a is true ", true, a);
		assertEquals("add: check last element is correct ", (Integer)44, list1.get(3));
		assertEquals("add: check size is correct ", 4, list1.size());
		assertEquals("add: check element is correct ", (Integer)44, list1.tail.prev.data);
		
//		list1.add(null);
		try {
			list1.add(null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("testSize: check size is correct ", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(2,44);

		assertEquals("testAddAtIndex: check element is correct ", (Integer)44, list1.get(2));
		assertEquals("testAddAtIndex: check element is correct ", (Integer)42, list1.get(3));
		assertEquals("testAddAtIndex: check size is correct ", 4, list1.size());
		assertEquals("testAddAtIndex: check element is correct ", (Integer)42, list1.tail.prev.data);
		
		list1.add(4,1);
		assertEquals("testAddAtIndex: check element is correct ", (Integer)1, list1.get(4));
		
		try {
			list1.add(0,null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
	
		try {
			list1.add(-1,666);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			list1.add(6,666);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		int a = list1.set(2,44);
		
		assertEquals("testSet: check a is correct ", 42, a);
		assertEquals("testSet: check element is correct ", (Integer)44, list1.get(2));
		assertEquals("testSet: check size is correct ", 3, list1.size());
		
		
		try {
			list1.set(0,null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			list1.set(6,666);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
