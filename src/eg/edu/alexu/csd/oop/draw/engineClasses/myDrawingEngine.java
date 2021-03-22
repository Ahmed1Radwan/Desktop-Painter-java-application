package eg.edu.alexu.csd.oop.draw.engineClasses;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.orders;



public class myDrawingEngine implements DrawingEngine {
	
	public List<orders> undoActions = new ArrayList<orders>();
	public List<orders> redoActions = new ArrayList<orders>();
	private ArrayList<Shape> shapes = new ArrayList<>();
	private ArrayList<myShape> myShapes = new ArrayList<>();
	private List<Class<? extends Shape>> supportedShapes = new ArrayList<Class<? extends Shape>>();
	
	public myDrawingEngine() {
		JavaClassLoader classLoader = new JavaClassLoader();
		String packageBinName = "eg.edu.alexu.csd.oop.draw.shapes."; 
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "Ellipse"));
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "Circle"));
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "LineSegment"));
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "Rectangle"));
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "Square"));
		this.supportedShapes.add(classLoader.loadExtraClass(packageBinName + "Triangle"));
		

		// for check round rectangle class plugin
		
		File file = new File("RoundRectangle.jar");
		String selectedFilePath = file.getAbsolutePath();
		selectedFilePath = selectedFilePath.replace("\\", "\\\\");
		int index = -1;
		for(int i=0;i<selectedFilePath.length();i++) {
			if(selectedFilePath.charAt(i) == '\\') {
				index = i;
			}
		}
		String subStr = selectedFilePath.substring(0, index+1);
		selectedFilePath = subStr+ "src\\\\RoundRectangle.jar";
		//System.out.println(selectedFilePath);
		
		
		try {
			JarInputStream jarFile = new JarInputStream(new FileInputStream(selectedFilePath));
			JarEntry jarEntry;
			ArrayList<String> names = new ArrayList<>();
			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if (jarEntry.getName().endsWith(".class")) {
					String classBinName = jarEntry.getName().replaceAll("/", "\\.");
					classBinName = classBinName.substring(0, classBinName.length() - 6);
					names.add(classBinName);
				}
			}

			ClassLoader loader = URLClassLoader
					.newInstance(new URL[] { new File(selectedFilePath).toURI().toURL() });
			Class<? extends Shape> cl = (Class<? extends Shape>) loader.getClass().forName(names.get(0), true,
					loader);
			if (cl.newInstance() instanceof Shape) {
				System.out.println(cl.getName());
				System.out.println(cl.getSimpleName());
				this.supportedShapes.add(cl);
			}
			jarFile.close();
			
			if(this.getSupportedShapes().contains(cl)) {
				System.out.println("Trueeeee");
			}
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		Shape[] shapes = getShapes();
		for (Shape i : shapes) {
			 i.draw(canvas);
		}
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		AddShape addShape = new AddShape(this.shapes, shape);
		addShape.execute();
		undoActions.add(addShape);
		redoActions.clear();
		if (undoActions.size() > 20) {
			undoActions.remove(0);
		}
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		RemoveShape removeShape = new RemoveShape(this.shapes, shape);
		removeShape.execute();
		undoActions.add(removeShape);
		if (undoActions.size() > 20) {
			undoActions.remove(0);
		}
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		UpdateShape updateShape = new UpdateShape(this.shapes, oldShape, newShape);
		updateShape.execute();
		undoActions.add(updateShape);
		if (undoActions.size() > 20) {
			undoActions.remove(0);
		}
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		Shape[] shapesArr = new Shape[this.shapes.size()];
		int cnt = 0;
		for (Shape i : this.shapes) {
			shapesArr[cnt++] = i;
		}
		return shapesArr;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return this.supportedShapes;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		try {
			orders action = undoActions.remove(undoActions.size() - 1);
			action.unexecute();
			redoActions.add(action);
			if (redoActions.size() > 20) {
				redoActions.remove(0);
			}
		} catch (Exception e) {
			throw new RuntimeException("nothing to undo");
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		try {
			orders action = redoActions.remove(redoActions.size() - 1);
			action.execute();
			undoActions.add(action);
			if (undoActions.size() > 20) {
				undoActions.remove(0);
			}
		} catch (Exception e) {
			throw new RuntimeException("nothing to redo");
		}
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		int dotIndex = path.lastIndexOf('.');
		String extension = path.substring(dotIndex + 1);

		if (extension.equalsIgnoreCase("XmL")) {
			XML xml = new XML(this);
			try {
				xml.save(path, this.shapes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (extension.equalsIgnoreCase("JsOn")) {
			Json json = new Json(this);
			try {
				json.save(path, this.shapes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("unexpected extension");
		}
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		this.shapes.clear();
		this.undoActions.clear();
		this.redoActions.clear();
		int dotIndex = path.lastIndexOf('.');
		String extension = path.substring(dotIndex + 1);
		if (extension.equalsIgnoreCase("XmL")) {
			XML xml = new XML(this);
			xml.load(path, this.shapes);
		} else if (extension.equalsIgnoreCase("JsOn")) {
			Json json = new Json(this);
			try {
				json.load(path, this.shapes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("unexpected extension");
		}
	}
	
	public void addPlugin(Class<? extends Shape> newClass){
		this.supportedShapes.add(newClass);
	}

}
