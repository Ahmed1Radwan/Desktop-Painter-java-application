package eg.edu.alexu.csd.oop.draw;

public interface orders {
	
	// all methods used in undo and redo part
	
	/**
	 * its a general method do adding a new shape or update or remove one 
	 */
	public void execute();
	/**
	 * return new shape when update it
	 */
	public Shape getNewShape();
	/**
	 * return old shape if update it
	 */
	public Shape getOldShape();
	/**
	 * its the opposite of execute method 
	 */
	public void unexecute();
}
