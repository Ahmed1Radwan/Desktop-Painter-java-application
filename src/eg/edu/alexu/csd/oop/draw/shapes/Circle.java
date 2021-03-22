package eg.edu.alexu.csd.oop.draw.shapes;

import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Circle extends Ellipse{
	
	public static final String keyRadius = "radius";
	
	//constructor
	public Circle() {
		super();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Shape copy = new Circle();
		copy.setColor(this.getColor());
		copy.setFillColor(this.getFillColor());
		copy.setPosition(this.getPosition());
		
		Map<String,Double> copied = new HashMap<String,Double>();
		for(Map.Entry it : this.getProperties().entrySet()) {
			String key = (String) it.getKey();
			Double value = (Double) it.getValue();
			copied.put(key,value);
		}
		
		copy.setProperties(copied);
		
		return copy;
	}
	
}
