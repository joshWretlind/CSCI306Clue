import java.util.LinkedList;

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
	
	@Test
	public void testAdjacency(){
		LinkedList testList =.getAdjList();
		Assert.assertTrue(!testList.isEmpty());
		Assert.assertTrue(testList.contains(1));
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.size() == 2);
		
	}
	
	@Test
	public void testIndex(){
		
	}
	
}
