import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IntBoard {
	private int row = 4;
	private int col = 4;
	private HashMap<Integer, LinkedList<Integer>> adj
		= new HashMap<Integer, LinkedList<Integer>>();
	private LinkedList<Integer> x;
	private boolean visited [] = new boolean [row*row];
	
	public IntBoard(){
		for (int i=0; i <Math.pow(row,2); i++) {
			visited[i] = false;
		}
	}
	
	public void calcAdjacencies(){
		for (int i=0; i <Math.pow(row,2); i++) {
			x = new LinkedList<Integer>();
			if (i==0) {
				x.add(1);
				x.add(row);
				adj.put(i, x);
			}
			else if (i==(Math.pow(row, 2)-1)){
				x.add(i-1);
				x.add(i-row);
				adj.put(i, x); 
			}
			else if (i==(Math.pow(row, 2)-row)) {
				x.add(i+1);
				x.add(i-row);
				adj.put(i, x);
			}
			else if (i==(row-1)) {
				x.add(i-1);
				x.add(i+row);
				adj.put(i, x);
			}
			else if (i%row==0 && i!=(Math.pow(row, 2)-row)) {
				x.add(i+1);
				x.add(i+row);
				x.add(i-row);
				adj.put(i, x); 
			}
			else if ((i+1)%row==0 && i!=(row-1)) {
				x.add(i-1);
				x.add(i+row);
				x.add(i-row);
				adj.put(i, x);
			}
			else if (i>0 && i<row-1) {
				x.add(i+1);
				x.add(i-1);
				x.add(i+row);
				adj.put(i, x);
			}
			else if (i<Math.pow(row, 2) && i>Math.pow(row, 2)-row) {
				x.add(i+1);
				x.add(i-1);
				x.add(i-row);
				adj.put(i, x);
			}
			else {
				x.add(i+1);
				x.add(i-1);
				x.add(i+row);
				x.add(i-row);
				adj.put(i, x);	 
			}
			
		}
	}
	
	public void calcTargets(int start, int steps){
		
	}
	
	public TreeSet getTargets(){
		return new TreeSet();
	}
	
	public LinkedList getAdjList(int indx){
		return adj.get(indx);
	}
	
	public int calcIndex(int r, int c){
		return row*r+c;
	}
	
	public static void main(String[] args) {
		IntBoard ib = new IntBoard();
		ib.calcAdjacencies();
		ib.calcTargets(0, 2);
	}

}

