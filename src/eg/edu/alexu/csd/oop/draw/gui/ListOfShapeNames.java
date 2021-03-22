package eg.edu.alexu.csd.oop.draw.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import eg.edu.alexu.csd.oop.draw.Shape;

public class ListOfShapeNames extends JList{
	
	private DefaultListModel<String> List;
	
	//constructor
	public ListOfShapeNames(Shape[] shapes) {
		super();
		
		List = new DefaultListModel();
		this.setModel(List);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for(Shape it : shapes) {
			List.addElement(it.getClass().getSimpleName());
		}
		this.setAutoscrolls(getAutoscrolls());
		this.setLayoutOrientation(JList.VERTICAL);
		this.setDragEnabled(false);
		this.setCellRenderer(getRenderer());
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.setBackground(new Color(245, 246, 247));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		
	}
	
	public void updateShapeNameList(Shape[] shapes) {
		List.clear();
		for (Shape i : shapes) {
			List.addElement(i.getClass().getSimpleName().toString());
		}
		System.out.println("updated");
	}

	public int getNum(Shape[] shapes, String type) {
		int count = 0;
		for (Shape i : shapes) {
			if (i.getClass().getSimpleName().equals(type)) {
				count++;
			}

		}
		return count;
	}
	
	private ListCellRenderer<? super String> getRenderer() {
		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
				return listCellRendererComponent;
			}
		};
	}
	
	public void addSelectShapeListner(ListSelectionListener listenForSelectShape) {
		this.addListSelectionListener(listenForSelectShape);
	}
}
