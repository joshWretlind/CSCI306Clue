package main.board;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BoardTest extends TestCase {
    public Board board;
    
    public BoardTest(String testName) {
        super(testName);
    }

    @Before
    public void beforeMethod(){
        board = new Board();
        try{
            board.loadConfigFiles("whatever the path is");
        }catch(Exception e){
            Assert.fail(e.toString());
        } 
    }
    @Test
    public void testConfigLoading(){
         board = new Board();
        try{
            board.loadConfigFiles("whatever the path is");
        }catch(Exception e){
            Assert.fail(e.toString());
        } 
    }
    
    @Test
    public void testBoardSizes(){
     
        Assert.assertEquals(board.numRows, board.cells.size()/board.numColumns);
        Assert.assertEquals(board.numColumns, board.cells.size()/board.numRows);
        Assert.assertEquals(board.numColumns*board.numRows, board.cells.size());
    }
    
    @Test
    public void testCalcIndex(){
        
        Assert.assertEquals(0, board.calcRoomIndex(0, 0));
        Assert.assertEquals(1, board.calcRoomIndex(0, 1));
        Assert.assertEquals(4*board.numColumns + 2, board.calcRoomIndex(4,2));
        Assert.assertEquals(board.numColumns, board.calcRoomIndex(0, board.numColumns));
    }
    
    @Test
    public void testBoardCharMapping(){
        
        Assert.assertEquals("Conservatory", board.rooms.get("C"));
        Assert.assertEquals("Library", board.rooms.get("L"));
        Assert.assertEquals("Walkway", board.rooms.get("W"));
    }
    
    @Test
    public void testNumRoomMap(){
        
        Assert.assertEquals(11, board.rooms.keySet().size());
        Assert.assertEquals(11, board.rooms.values().size());
        Assert.assertEquals(11,board.rooms.size());
    }
}
