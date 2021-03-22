package eg.edu.alexu.csd.oop.draw.engineClasses;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.createShape;

public class drawShape implements createShape {
	
	private Shape shape = null;
	private DrawingEngine engine;
	
	//constructors
	public drawShape() {
		
	}
	public drawShape(DrawingEngine engine) {
		this.engine = engine;
	}
	
	@Override
	public Shape createShape(String shape) {
		// TODO Auto-generated method stub
		for (Class<? extends Shape> i : engine.getSupportedShapes()) {
			if (shape.equals(i.getSimpleName())) {
				try {
					Constructor<?> constuctor = null;
					try {
						constuctor = i.getConstructor();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}

					try {
						this.shape =  (Shape) constuctor.newInstance();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					return this.shape;

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

}
