package eg.edu.alexu.csd.oop.draw.shapes;

import java.awt.BasicStroke;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.engineClasses.myShape;

public class LineSegment extends myShape{
	
	private Map<String,Double> properties = new HashMap<String,Double>();
	
	public static final String keyX1 = "x1";
	public static final String keyX2 = "x2";
	public static final String keyY1 = "y1";
	public static final String keyY2 = "y2";
	
	//Constructor
	public LineSegment() {
		this.properties.put("stroke",(double)3.0f);
		this.properties.put(keyX1, 0.0);
		this.properties.put(keyX2, 0.0);
		this.properties.put(keyY1, 0.0);
		this.properties.put(keyY2, 0.0);
		
		setPosition(this.getPosition());
		setColor(this.getColor());
		setFillColor(this.getFillColor());
		setProperties(this.properties);
		
		
	}
	
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g = (Graphics2D) canvas;
		double stroke = this.properties.get("stroke");
		
		Point position = new Point(getProperties().get(keyX2).intValue(), getProperties().get(keyY2).intValue());
		setPosition(position);
		
		// for thickness
		g.setStroke(new BasicStroke((float)stroke));
		
		canvas.setColor(getColor());
		canvas.drawLine(getPosition().x, getPosition().y, getProperties().get(keyX1).intValue(), getProperties().get(keyY1).intValue());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Shape copy = new LineSegment();
		copy.setColor(this.getColor());
		copy.setFillColor(this.getFillColor());
		copy.setPosition(this.getPosition());
		
		Map<String,Double> copied = new HashMap<String,Double>();
		for(Map.Entry it : this.properties.entrySet()) {
			
			String key = (String) it.getKey();
			Double value = (Double) it.getValue();
			copied.put(key, value);
		}
		
		copy.setProperties(copied);
		return copy;
	}
	
	@Override
	public void setProperties(Map<String,Double> properties) {
		this.properties = properties;
	}
	
	@Override
	public Map<String,Double> getProperties() {
		return this.properties;
	}
	
	
}
