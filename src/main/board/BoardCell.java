package main.board;

public abstract class BoardCell {
	
    int row;
    int col;
    
	public boolean isWalkway(){
        return false;
    }
    
	public boolean isDoorway(){
		return false;
	}
    
    public boolean isRoom(){
        return false;
    }
    
    public abstract void draw();
}
