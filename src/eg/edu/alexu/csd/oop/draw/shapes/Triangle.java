package eg.edu.alexu.csd.oop.draw.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.engineClasses.myShape;

public class Triangle extends myShape{
	
	private Map<String,Double> properties = new HashMap<String,Double>();
	public static final String keyX1 = "x1";
	public static final String keyX2 = "x2";
	public static final String keyX3 = "x3";
	public static final String keyY1 = "y1";
	public static final String keyY2 = "y2";
	public static final String keyY3 = "y3";
	
	//constructor
	public Triangle() {
		this.properties.put("stroke",(double)3.0f);
		this.properties.put(keyX1,0.0);
		this.properties.put(keyX2,0.0);
		this.properties.put(keyX3,0.0);
		this.properties.put(keyY1,0.0);
		this.properties.put(keyY2,0.0);
		this.properties.put(keyY3,0.0);
		
		setPosition(this.getPosition());
		setColor(this.getColor());
		setFillColor(this.getFillColor());
		setProperties(this.properties);
	}
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g = (Graphics2D) canvas;
		double stroke = this.properties.get("stroke");
		g.setStroke(new BasicStroke((float) stroke));
		
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = getProperties().get(keyX1).intValue();
		x[1] = getProperties().get(keyX2).intValue();
		x[2] = getProperties().get(keyX3).intValue();
		y[0] = getProperties().get(keyY1).intValue();
		y[1] = getProperties().get(keyY2).intValue();
		y[2] = getProperties().get(keyY3).intValue();
		
		g.setColor(getColor());
		g.drawPolygon(x, y, 3);
		g.setColor(getFillColor());
		g.fillPolygon(x, y, 3);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Shape copy = new Triangle();
		copy.setColor(this.getColor());
		copy.setFillColor(this.getFillColor());
		copy.setPosition(this.getPosition());
        Map<String, Double> copied = new HashMap<String,Double>();
        for (Map.Entry s: this.properties.entrySet()){
            String key = (String) s.getKey(); 
            Double value = (Double) s.getValue();
            copied.put(key, value);
        }
        
        copy.setProperties(copied);
		return copy;
	}
	
	@Override
	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		return this.properties;
	}

}
