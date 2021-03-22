package eg.edu.alexu.csd.oop.draw.main;

import java.io.File;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.swing.JFileChooser;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.engineClasses.drawShape;

import eg.edu.alexu.csd.oop.draw.engineClasses.myDrawingEngine;
import eg.edu.alexu.csd.oop.draw.gui.GUI;
import eg.edu.alexu.csd.oop.draw.gui.shapesBox;
import eg.edu.alexu.csd.oop.draw.gui.shapesPanel;
import eg.edu.alexu.csd.oop.draw.main.MainController.ShapeCreationBtnListner;



public class painter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myDrawingEngine engine = engine = new myDrawingEngine();
		final GUI paint = new GUI();
		drawShape factory = new drawShape(engine);
		MainController main = new MainController(engine, factory, paint);
		java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
            	paint.setVisible(true);
            	
            }
        });
		
	
		
	}
}
