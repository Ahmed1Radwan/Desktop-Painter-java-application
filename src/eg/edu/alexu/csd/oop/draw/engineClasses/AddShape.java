package eg.edu.alexu.csd.oop.draw.engineClasses;

import java.util.ArrayList;


import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.orders;

public class AddShape implements orders {
	
	private ArrayList<Shape> shapes;
	private Shape shape;
	public AddShape(ArrayList<Shape> shapes, Shape shape){
		this.shapes = shapes;
		this.shape = shape;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.shapes.add(shape);
	}

	@Override
	public Shape getNewShape() {
		// TODO Auto-generated method stub
		return shape;
	}

	@Override
	public Shape getOldShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		this.shapes.remove(shape);
	}

}
