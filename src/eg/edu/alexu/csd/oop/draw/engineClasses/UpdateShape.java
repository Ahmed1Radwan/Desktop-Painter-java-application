package eg.edu.alexu.csd.oop.draw.engineClasses;

import java.util.ArrayList;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.orders;

public class UpdateShape implements orders {

	
	private ArrayList<Shape> shapes;
	private Shape oldShape;
	private Shape newShape;
	public UpdateShape(ArrayList<Shape> shapes, Shape oldShape, Shape newShape){
		this.shapes = shapes;
		this.oldShape = oldShape;
		this.newShape = newShape;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int index = this.shapes.indexOf(oldShape);
		this.shapes.remove(oldShape);
		this.shapes.add(index, newShape);
	}

	@Override
	public Shape getNewShape() {
		// TODO Auto-generated method stub
		return newShape;
	}

	@Override
	public Shape getOldShape() {
		// TODO Auto-generated method stub
		return oldShape;
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		int index = this.shapes.indexOf(newShape);
		this.shapes.remove(newShape);
		this.shapes.add(index, oldShape);
	}

}
