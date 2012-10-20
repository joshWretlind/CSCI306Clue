package main.board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import main.board.RoomCell.DoorDirection;

public class Board {

	ArrayList<BoardCell> cells;
	Map<Character, String> rooms;
	HashMap<BoardCell, List<Integer>> adj;
	LinkedList<Integer> adjList;
	Set<BoardCell> targets;
	boolean visited[][];
	int numRows;
	int numColumns;

	public Board() {
		cells = new ArrayList<BoardCell>();
		rooms = new HashMap<Character, String>();
		adj = new HashMap<BoardCell, List<Integer>>();
		
		targets = new HashSet<BoardCell>();
	}

	// ---DONE---
	public void loadConfigFiles(String path) throws BadConfigException {
		FileReader reader;
		Scanner scn;
		try {
			reader = new FileReader(path);
			scn = new Scanner(reader);
			String line;
			String temp;

			while (scn.hasNextLine()) {
				line = scn.nextLine();
				numColumns = line.split(",").length;
				numRows++;
				temp = "";
				for (int indx = 0; indx < line.length(); indx++) {
					// last index in a line
					if (indx == line.length() - 1) {
						temp += line.charAt(indx);
						if (temp.equals("W")) {
							WalkWayCell wc = new WalkWayCell(temp);
							cells.add(wc);
						} else if (temp.length() > 1) {
							RoomCell rc = new RoomCell(temp);
							rc.initial = temp.charAt(0);
							if (temp.charAt(1) == 'U') {
								rc.setDoorDir(DoorDirection.UP);
							}
							else if (temp.charAt(1) == 'D') {
								rc.setDoorDir(DoorDirection.DOWN);
							}
							else if (temp.charAt(1) == 'R') {
								rc.setDoorDir(DoorDirection.RIGHT);
							}
							else if (temp.charAt(1) == 'L') {
								rc.setDoorDir(DoorDirection.LEFT);
							}
							rc.setDoorway(true);
							cells.add(rc);
						} else {
							RoomCell rc = new RoomCell(temp);
							rc.initial = temp.charAt(0);
							cells.add(rc);
						}
						temp = "";
					}

					else if (line.charAt(indx) != ',') {
						temp += line.charAt(indx);
					}

					else {
						if (temp.equals("W")) {
							WalkWayCell wc = new WalkWayCell(temp);
							cells.add(wc);
						} else if (temp.length() > 1) {
							RoomCell rc = new RoomCell(temp);
							rc.initial = temp.charAt(0);
							if (temp.charAt(1) == 'U') {
								rc.setDoorDir(DoorDirection.UP);
							}
							if (temp.charAt(1) == 'D') {
								rc.setDoorDir(DoorDirection.DOWN);
							}
							if (temp.charAt(1) == 'R') {
								rc.setDoorDir(DoorDirection.RIGHT);
							}
							if (temp.charAt(1) == 'L') {
								rc.setDoorDir(DoorDirection.LEFT);
							}
							rc.setDoorway(true);
							cells.add(rc);
						} else {
							RoomCell rc = new RoomCell(temp);
							rc.initial = temp.charAt(0);
							rc.setRoom(true);
							cells.add(rc);
						}
						temp = "";
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		visited = new boolean[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				visited[i][j] = false;
			}
		}
	}

	// ---DONE---
	public void loadLegend(String path) {
		FileReader reader;
		Scanner scn;
		try {
			reader = new FileReader(path);
			scn = new Scanner(reader);
			String line;
			char init;
			String rom;
			while (scn.hasNext()) {
				line = scn.nextLine();
				init = line.charAt(0);
				rom = line.substring(2);
				rooms.put(init, rom);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// ---Get The Index Of A Cell Using Row and Col---
	public int calcRoomIndex(int row, int col) {
		return row * numColumns + col;
	}

	// ---Get Room Cell Using Row & Col---
	public RoomCell getRoomCellAt(int row, int col) {
		if (cells.get(calcRoomIndex(row, col)).isRoom()){//getClass().equals(RoomCell.class)) {
			return (RoomCell) cells.get(calcRoomIndex(row, col));
		} else {
			return null;
		}
	}

	// ---Get Rows Of The Board---
	public int getNumRows() {
		return numRows;
	}

	// ---Get Columns Of The Board---
	public int getNumColumns() {
		return numColumns;
	}

	// ---Get Board Cell Row---
	public int getRow(int indx, int BoardCols) {
		return (int) (indx / BoardCols);
	}

	// ---Get Board Cell Column---
	public int getColumn(int indx, int BoardCols) {
		return indx % BoardCols;
	}

	// ---Get Board Cell Using INDX---
	public BoardCell getCellAt(int indx) {
		return cells.get(indx);
	}

	// ---Get Board Cell Using ROW & COL---
	public BoardCell getCellAt(int row, int col) {
		return cells.get(calcRoomIndex(row, col));
	}

	// ---Calculate The Adjacency List---
	public void calcAdjacencies() {
		BoardCell bc;
		RoomCell rc;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				bc = getCellAt(i, j);
				adjList = new LinkedList<Integer>();
				// ---inside a room
				if (bc.isRoom()) {
					// ---door cell
					if (bc.isDoorway()) {
						rc = (RoomCell) bc;
						if (rc.getDoorDir().equals(DoorDirection.UP)) {
							adjList.add(numColumns * (i - 1) + j);
						} else if (rc.getDoorDir().equals(DoorDirection.DOWN)) {
							adjList.add(numColumns * (i + 1) + j);
						} else if (rc.getDoorDir().equals(DoorDirection.RIGHT)) {
							adjList.add(numColumns * i + j + 1);
						} else if (rc.getDoorDir().equals(DoorDirection.LEFT)) {
							adjList.add(numColumns * i + j - 1);
						}
						
					}
				} else if (bc.isWalkway()) {
					//directions
					boolean top = false;
					boolean bottom = false;
					boolean right = false;
					boolean left = false;

					if ((j + 1) == numColumns) {
						right = true;
					}
					
					if ((j - 1) == -1) {
						left = true;
					}
		
					if (i - 1 == -1) {
						top = true;
					}
					
					if ((i + 1) == numRows) {
						bottom = true;
					}
					
					if (!left && (!getCellAt(i,j-1).isRoom() || getCellAt(i,j-1).isDoorway())){
						if (getCellAt(i,j-1).isDoorway()) {
							if (((RoomCell) (getCellAt(i,j-1))).getDoorDir().equals(DoorDirection.RIGHT) ) {
								adjList.add(numColumns * i + (j-1));
							}
						}
						else {
							adjList.add(numColumns * i + (j-1));
						}
						
					}
					if (!right && (!getCellAt(i,j+1).isRoom() || getCellAt(i,j+1).isDoorway())){
						if (getCellAt(i,j+1).isDoorway()) {
							if (((RoomCell) (getCellAt(i,j+1))).getDoorDir().equals(DoorDirection.LEFT) ) {
								adjList.add(numColumns * i + (j+1));
							}
						}
						else {
							adjList.add(numColumns * i + (j+1));
						}
					}
					if (!top && (!getCellAt(i-1,j).isRoom() || getCellAt(i-1,j).isDoorway())){
						if (getCellAt(i-1,j).isDoorway()) {
							if (((RoomCell) (getCellAt(i-1,j))).getDoorDir().equals(DoorDirection.DOWN) ) {
								adjList.add(numColumns * (i-1) + j);
							}
						}
						else {
							adjList.add(numColumns * (i-1) + j);
						}
					}
					if (!bottom && (!getCellAt(i+1,j).isRoom() || getCellAt(i+1,j).isDoorway())){
						if (getCellAt(i+1,j).isDoorway()) {
							if (((RoomCell) (getCellAt(i+1,j))).getDoorDir().equals(DoorDirection.UP) ) {
								adjList.add(numColumns * (i+1) + j);
							}
						}
						else {
							adjList.add(numColumns * (i+1) + j);
						}
					}
				}

				adj.put(getCellAt(numColumns * i + j), adjList);
				//checking...
				//System.out.println(numColumns * i + j+""+adj.get(getCellAt(numColumns*i+j)));
				//System.out.println(adj);
			}
		}
	}

	// ---List Of Adjacency---
	public LinkedList<Integer> getAdjList(BoardCell bc) {
		return (LinkedList<Integer>) adj.get(bc);
	}

	// ---Calculate Targets---
	public void calcTargets(int indx, int steps) {
		int rowT = this.getRow(indx, numColumns);
		int colT = this.getColumn(indx, numColumns);

		if ((visited[rowT][colT] == false && steps == 0)) {
			targets.add(getCellAt(rowT, colT));
			return;
		} else {
			for (int k : adj.get(getCellAt(numColumns * rowT + colT))) {
				visited[rowT][colT] = true;
				if (!visited[(int) (k / numColumns)][k % numColumns]) {
					if (getCellAt(k).isDoorway()){
						targets.add(getCellAt(k));
					}
					calcTargets(k, steps - 1);
				}
				visited[rowT][colT] = false;
			}
			
		}

	}

	// ---Set Of Targets---
	public Set<BoardCell> getTargets() {
		return targets;
	}

	// ---Get All Doors Of A Room---
	/*public LinkedList<Integer> doorsOfRoom(int indx) {
		LinkedList<Integer> doors = new LinkedList<Integer>();
		char roomInitial = cells.get(indx).toString().charAt(0);
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (getCellAt(i, j).toString().length() > 1 && 
						getCellAt(i, j).toString().charAt(0) == roomInitial) {
					doors.add(numColumns * i + j);
				}
			}
		}
		
		return doors;
	}*/

	
	// ......."Main" is: ONLY FOR TESTING AND DEBUGGING .~_~.
	public static void main(String[] args) throws FileNotFoundException {
		Board b = new Board();
		
		FileReader redr = new FileReader("work1.csv");
		Scanner s = new Scanner(redr);
		try {
			b.loadConfigFiles("work1.csv");
		} catch (BadConfigException e) {
			e.printStackTrace();
		}
		b.loadLegend("initials.csv");
		//System.out.println(b.numRows);
		//System.out.println(b.numColumns);
		//System.out.println(b.cells.size());
		//System.out.println(b.getColumn(25, 23));
		//System.out.println(b.getRow(25, 23));
		//System.out.println(b.cells.get(0).isDoorway());
		b.calcAdjacencies();
		LinkedList<Integer> testList = b.getAdjList(b.getCellAt(0));
		System.out.println(testList);
		/*System.out.println(b.getCellAt(0));
		System.out.println(b.getCellAt(1));
		System.out.println(b.getCellAt(2));
		System.out.println(b.getCellAt(3));
		System.out.println(b.getCellAt(4));
		System.out.println(b.getCellAt(5));*/
		//System.out.println(b.getCellAt(320));
		System.out.println();
		System.out.println(b.adj.get(b.getCellAt(4,2)));

	}

}
