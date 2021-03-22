package eg.edu.alexu.csd.oop.draw.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.engineClasses.myShape;

public class Rectangle extends myShape{
	
	private Map<String,Double> properties = new HashMap<String,Double>();
	public static final String keyLength = "xAxis";
	public static final String keyWidth = "yAxis";
	
	//constructor
	public Rectangle() {
		this.properties.put("stroke",(double)3.0f);
		this.properties.put(keyLength, 0.0);
		this.properties.put(keyWidth, 0.0);
		
		setPosition(this.getPosition());
		setColor(this.getColor());
		setFillColor(this.getFillColor());
		setProperties(this.properties);
	}
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g2 = (Graphics2D) canvas;
		
		double stroke = this.properties.get("stroke");
		g2.setStroke(new BasicStroke((float) stroke));
		
		Point position = getPosition();
		double length = getProperties().get(keyLength);
		double width = getProperties().get(keyWidth);
		
		g2.setColor(getColor());
		g2.drawRect(position.x, position.y, (int)width, (int)length);
		g2.setColor(getFillColor());
		g2.fillRect(position.x, position.y, (int)width, (int)length);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Shape copy = new Rectangle();
		copy.setColor(this.getColor());
		copy.setFillColor(this.getFillColor());
		copy.setPosition(this.getPosition());
		
		Map<String,Double> copied = new HashMap<String,Double>();
		for(Map.Entry it : this.properties.entrySet()) {
			String key = (String) it.getKey();
			Double value = (Double) it.getValue();
			copied.put(key,value);
		}
		
		copy.setProperties(copied);
		return copy;
	}
	
	
	@Override
	public void setProperties(Map<String,Double> properties) {
		this.properties = properties;
	}
	@Override
	public Map<String,Double> getProperties(){
		return this.properties;
	}
}
