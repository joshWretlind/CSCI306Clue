package main.board;

public class WalkWayCell extends BoardCell{

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isWalkway(){
        return true;
    }

}
