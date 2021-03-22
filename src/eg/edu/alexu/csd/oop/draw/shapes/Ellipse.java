package eg.edu.alexu.csd.oop.draw.shapes;

import java.awt.BasicStroke;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.engineClasses.myShape;

public class Ellipse extends myShape{
	
	private Map<String,Double> properties = new HashMap<String,Double>();
	
	public static final String keyX ="xAxis";
	public static final String keyY ="yAxis";
	
	//constructor
	public Ellipse() {
		this.properties.put("stroke",(double)3.0f);
		this.properties.put(keyX, 0.0);
		this.properties.put(keyY, 0.0);
		
		setPosition(this.getPosition());
		setColor(this.getColor());
		setFillColor(this.getFillColor());	
		setProperties(this.getProperties());
		
	}
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g = (Graphics2D) canvas;
		
		double stroke = getProperties().get("stroke");
		g.setStroke(new BasicStroke((float)stroke));
		
		Point position = getPosition();
		double x = getProperties().get(keyX);
		double y = getProperties().get(keyY);
		
		g.setColor(getColor());
		g.drawOval(position.x, position.y, (int)x, (int)y);
		g.setColor(getFillColor());
		g.fillOval(position.x, position.y, (int)x, (int)y);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Shape copy = new Ellipse();
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
	public Map<String,Double> getProperties(){
		return this.properties;
	}
	
	
}
