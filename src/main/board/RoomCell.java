package main.board;

public class RoomCell extends BoardCell{

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	enum DoorDirection{
		UP, DOWN, LEFT, RIGHT, NONE
	}
	
	private DoorDirection doorDirection;
	char initial;
	
    @Override
	public boolean isRoom(){
		return true;
	}
}
