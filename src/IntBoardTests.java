import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;


public class IntBoardTests extends TestCase {
	IntBoard board;
	
	@Before
	public void setup(){
		board = new IntBoard();
	}
	
	public IntBoardTests(){
		board = new IntBoard();
	}
	
	//fail
	@Test
	public void testAdjacency(){
		LinkedList testList = board.getAdjList();
		Assert.assertTrue(!testList.isEmpty());
		Assert.assertTrue(testList.contains(1));
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.size() == 2);
		
	}
	
	//fail
	@Test
	public void testTargets0_3()
	{
		board.calcTargets(0, 3);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(3));
		Assert.assertTrue(targets.contains(4));
	}
	
	//fail
	@Test
	public void testTargets0_1()
	{
		board.calcTargets(0, 1);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(2, targets.size());
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(4));
		
	}
	
	//fail
	@Test
	public void testTargets1_2()
	{
		board.calcTargets(1, 2);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(4, targets.size());
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(3));
		Assert.assertTrue(targets.contains(4));
		
	}
	
	//fail
	@Test
	public void testTargets5_1()
	{
		board.calcTargets(5, 1);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(4, targets.size());
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(4));
		
	}
	
	//fail
	@Test
	public void testTargets13_1()
	{
		board.calcTargets(5, 1);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(3, targets.size());
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(14));
		
	}
	
	//fail
	@Test
	public void testTargets11_1()
	{
		board.calcTargets(11, 1);
		TreeSet targets= board.getTargets();
		Assert.assertEquals(3, targets.size());
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(15));
		
	}
	
	//fail
	@Test
	public void testIndex(){
		int actual = board.calcIndex(2, 3);
		int expected = 0;
		Assert.assertEquals(expected, actual);
	}
	
}