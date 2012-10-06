import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class IntBoard {
	final int ROW = 4;
	final int COL = 4;
	
	public IntBoard(){
		
	}
	
	public void calcAdjacencies(){
		
	}
	
	public void calcTargets(int start, int steps){
		
	}
	
	public TreeSet getTargets(){
		return new TreeSet();
	}
	
	public LinkedList getAdjList(int indx){
		return new LinkedList();
	}
	
	public static int calcIndex(int row, int col){
		return row*row+col;
	}

}
