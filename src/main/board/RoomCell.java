package main.board;

public class RoomCell extends BoardCell{

	enum DoorDirection{
		UP, DOWN, LEFT, RIGHT, NONE
	}
	
	private DoorDirection doorDirection;
	char initial;
	
	public boolean isRoom(){
		return true;
	}
}
