
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IntBoard {

    private int row = 4;
    private int col = 4;
    // Note: we should probably, for the sake of good design, use a Board Cell object instead of Integers here. That way we can store both the i and j position and clean up the adjacency list code quite a bit.
    private HashMap<Integer, List<Integer>> adj = new HashMap<>();
    private List adjList;
    private List targets;
    private boolean visited[][];

    public IntBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
    }

    public void calcAdjacencies() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != j) {
                    boolean top = false;
                    boolean bottom = false;
                    boolean right = false;
                    boolean left = false;
                    if ((i + 1) == row) {
                        right = true;
                    }
                    if ((i - 1) == -1) {
                        left = true;
                    }
                    if (j - 1 == -1) {
                        top = true;
                    }
                    if ((j + 1) == col) {
                        bottom = true;
                    }
                    adjList = new LinkedList<Integer>();
                    if (!right) {
                        adjList.add(4 * j + i + 1);
                    }
                    if (!left) {
                        adjList.add(4 * j + i - 1);
                    }
                    if (!top) {
                        adjList.add(4 * (j - 1) + i);
                    }
                    if (!bottom) {
                        adjList.add(4 * (j + 1) + i);
                    }
                    adj.put(4*j + i, adjList);
                }

            }
        }
    }

    public void calcTargets(int rowT, int colT, int steps) {
        for (int i = 0; i < steps; i++) {
            for (Object o : getAdjList(start)) {
            }
        }
    }

    public TreeSet getTargets() {
        return new TreeSet();
    }

    public LinkedList getAdjList(int indx) {
        return (LinkedList) adj.get(indx);
    }

    public int calcIndex(int r, int c) {
        return row * r + c;
    }

    public static void main(String[] args) {
        IntBoard ib = new IntBoard();
        ib.calcAdjacencies();
        ib.calcTargets(0, 2);
    }
}
