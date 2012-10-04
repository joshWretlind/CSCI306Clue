import java.util.LinkedList;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;


public class IntBoardTests extends TestCase {
	IntBoard board;
	
	public IntBoardTests(){
		board = new IntBoard();
	}
	
	@Test
	public void testAdjacency(){
		LinkedList testList = (LinkedList) board.getAdjList();
		Assert.assertTrue(!testList.isEmpty());
		Assert.assertTrue(testList.contains(1));
		Assert.assertTrue(testList.contains(4));
		
	}
}
