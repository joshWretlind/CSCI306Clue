package main.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

    List<BoardCell> cells;
    Map<Character, String> rooms;
    int numRows;
    int numColumns;
    
    public Board(){
        cells = new ArrayList<BoardCell>();
        
    }
    
    public void loadConfigFiles(String path) throws BadConfigException{
        //Do stuff
    }
    
    public int calcRoomIndex(int row, int col){
        return row*numRows + col;
    }
    
    public RoomCell getBoardCell(int row, int col){
        return (RoomCell)cells.get(calcRoomIndex(row,col));
    } 
}
