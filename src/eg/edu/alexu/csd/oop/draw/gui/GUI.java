package eg.edu.alexu.csd.oop.draw.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;



public class GUI extends JFrame{
	

	// first menu
	private final JMenuBar menuBar= new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnSave = new JMenu("Save");
	private final JMenuItem mntmSaveXml = new JMenuItem("Save as XML");
	private final JMenuItem mntmSaveJson = new JMenuItem("Save as JSON");
	private final JMenuItem mntmLoad = new JMenuItem("Load");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	// second menu
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenuItem mntmUndo = new JMenuItem("Undo");
	private final JMenuItem mntmRedo = new JMenuItem("Redo");
	private final JMenuItem mntmDelete = new JMenuItem("Delete");
	// third menu
	private final JMenu mnPlugins = new JMenu("Plugins");
	private final JMenuItem mntmAddPlugin = new JMenuItem("Add Plugin..");
	// forth menu
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmUserGuide = new JMenuItem("User Guide");
	// seperators
	private final JSeparator separator_1 = new JSeparator();
	private final JSeparator separator_2 = new JSeparator();
	private final JSeparator separator_3 = new JSeparator();
	
	// label and buttons for options
	private final JPanel ToolsPanel = new JPanel();
	private final JPanel statusPanel = new JPanel();
	public final JLabel mouseXlbl = new JLabel("X: ");
	public final JLabel mouseYlbl = new JLabel("Y: ");
	private final JLabel lblPalette = new JLabel("Palette");
	private final JLabel lblDelete = new JLabel("");

	public final JButton btnColor = new JButton("");
	public final JButton btnFillColor = new JButton("");
	public final JButton btnMove = new JButton("Move");
	private final JButton btnDelete = new JButton("Delete");
	private final JButton btnRedo = new JButton("Redo");
	private final JButton btnUndo = new JButton("Undo");
	private final JButton btnResize = new JButton("Resize");
	private final JButton btnPalette = new JButton("");
	
	//constructor
	
	public GUI() {
		
		getContentPane().setForeground(Color.WHITE);
		
		// menu
		
		setJMenuBar(menuBar);

		menuBar.add(mnFile);

		mnFile.add(mntmLoad);

		mnFile.add(mnSave);

		mnSave.add(mntmSaveXml);

		mnSave.add(mntmSaveJson);

		mnFile.add(mntmExit);

		menuBar.add(mnEdit);

		mnEdit.add(mntmUndo);

		mnEdit.add(mntmRedo);

		
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

		mnEdit.add(mntmDelete);

		menuBar.add(mnPlugins);

		mnPlugins.add(mntmAddPlugin);
		
		menuBar.add(mnHelp);
		
		mnHelp.add(mntmUserGuide);
		
		
		// palette button and label
		lblPalette.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalette.setFont(new Font("Thema",Font.PLAIN,10));
		btnPalette.setIcon(new ImageIcon(GUI.class.getResource("/iconImages/palette.png")));
		btnPalette.setToolTipText("Palette");
		btnPalette.setFocusPainted(false);
		btnPalette.setBorderPainted(false);
		btnPalette.setBackground(new Color(245, 246, 247));
		addButtonHover(btnPalette,new buttonHover());
		
		// redo button  
		
		btnRedo.setBackground(new Color(245, 246, 247));
		btnRedo.setBorderPainted(false);
		btnRedo.setFocusPainted(false);
		addButtonHover(btnRedo, new buttonHover());
		
		// undo button
		
		
		btnUndo.setBackground(new Color(245, 246, 247));
		btnUndo.setBorderPainted(false);
		btnUndo.setFocusPainted(false);
		addButtonHover(btnUndo, new buttonHover());
		
		
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(SystemColor.controlShadow);
		separator_3.setBackground(Color.WHITE);
		
		// delete label and button
		
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		btnDelete.setBackground(new Color(245, 246, 247));
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);
		addButtonHover(btnDelete, new buttonHover());
		
		separator_1.setForeground(new Color(160, 160, 160));
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		
		// drawing background and the tools layout at north
		getContentPane().setBackground(Color.WHITE);
		this.setSize(995, 650);
		getContentPane().setLayout(new BorderLayout(0, 0));
		ToolsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ToolsPanel.setBackground(new Color(245, 246, 247));//245 246 247
		getContentPane().add(ToolsPanel, BorderLayout.NORTH);

		
		// move button
				
		
		btnMove.setBackground(new Color(245, 246, 247));
		btnMove.setBorderPainted(false);
		btnMove.setFocusPainted(false);
		addButtonHover(btnMove, new buttonHover());
				
		// resize button
				
		btnResize.setBackground(new Color(245, 246, 247));
		btnResize.setBorderPainted(false);
		btnResize.setFocusPainted(false);
		addButtonHover(btnResize, new buttonHover());
		
		
		// label color and  fillColor 
		
		JLabel lblNewLabel_1 = new JLabel("Fill Color");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblOuterColor = new JLabel("Outer Color");
		lblOuterColor.setHorizontalAlignment(SwingConstants.CENTER);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(SystemColor.controlShadow);
		separator_4.setBackground(Color.WHITE);
		btnFillColor.setToolTipText("Fill Color");
		btnFillColor.setBackground(Color.WHITE);
		btnFillColor.setFocusPainted(false);
		btnColor.setToolTipText("Outer Color");
		btnColor.setBackground(Color.BLACK);
		btnColor.setFocusPainted(false);
		
		
		GroupLayout gl_ToolsPanel = new GroupLayout(ToolsPanel);
		// Horizontal
		gl_ToolsPanel.setHorizontalGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
				.addGap(10)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)//43
						.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))//43
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
				)
				.addGap(6)
				.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnResize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(6)
				.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
				)
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOuterColor))
				.addGap(10)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
						  .addGroup(gl_ToolsPanel.createSequentialGroup()
							.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPalette, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPalette, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
				)
				.addGap(6)
				.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addGap(6)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 60)
					.addComponent(lblDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 60)))
	           );
		
		// vertical
		gl_ToolsPanel.setVerticalGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
				.addGap(11)
				.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
					.addComponent(btnRedo))
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					
				.addGap(6)
				)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					.addComponent(btnMove)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnResize, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					
					.addGap(2)
				)
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblOuterColor))
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_ToolsPanel.createSequentialGroup()
						.addGroup(gl_ToolsPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ToolsPanel.createSequentialGroup()
									.addComponent(btnPalette, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(lblPalette)))
							.addGap(2)
				)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
				
				.addGroup(gl_ToolsPanel.createSequentialGroup()
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblDelete)))
			         .addContainerGap())
			);
		
		gl_ToolsPanel.setAutoCreateGaps(true);
		gl_ToolsPanel.setAutoCreateContainerGaps(true);
		ToolsPanel.setLayout(gl_ToolsPanel);
		statusPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
		
		GroupLayout gl_statusPanel = new GroupLayout(statusPanel);
		gl_statusPanel.setHorizontalGroup(gl_statusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statusPanel.createSequentialGroup()
						.addComponent(mouseXlbl, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(mouseYlbl)
						.addContainerGap(827, Short.MAX_VALUE)));
		gl_statusPanel.setVerticalGroup(gl_statusPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_statusPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(mouseXlbl, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(mouseYlbl)));
		statusPanel.setLayout(gl_statusPanel);
		
		mntmLoad.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke('Y', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		
		
		
		this.setVisible(true);
		
	}
	
	public void addExitListener(ActionListener listenforExit) {
		mntmExit.addActionListener(listenforExit);
	}

	public void addUndoListener(ActionListener listenforUndo) {
		mntmUndo.addActionListener(listenforUndo);
		btnUndo.addActionListener(listenforUndo);
	}

	public void addRedoListener(ActionListener listenforRedo) {
		mntmRedo.addActionListener(listenforRedo);
		btnRedo.addActionListener(listenforRedo);
	}


	public void addDeleteListener(ActionListener listenforDelete) {
		mntmDelete.addActionListener(listenforDelete);
		btnDelete.addActionListener(listenforDelete);
	}

	public void saveXmlListener(ActionListener listenforSaveXml) {
		mntmSaveXml.addActionListener(listenforSaveXml);
	}

	public void saveJsonListener(ActionListener listenforSaveJson) {
		mntmSaveJson.addActionListener(listenforSaveJson);
	}

	public void loadListener(ActionListener listenforLoad) {
		mntmLoad.addActionListener(listenforLoad);
	}

	public void colorListener(ActionListener listenForColor) {
		btnColor.addActionListener(listenForColor);
	}
	
	public void addPaletteListener(ActionListener listenForPallete) {
		btnPalette.addActionListener(listenForPallete);
	}

	public void fillColorListener(ActionListener listenForFillColor) {
		btnFillColor.addActionListener(listenForFillColor);
	}

	public void moveListener(ActionListener listenForMove) {
		btnMove.addActionListener(listenForMove);
	}
	
	public void resizeListener(ActionListener listenForResize) {
		btnResize.addActionListener(listenForResize);
	}

	public void addAddPluginListener(ActionListener listenForAddPlugin) {
		mntmAddPlugin.addActionListener(listenForAddPlugin);
	}

	
	public void addButtonHover(JButton myButton, MouseListener listenForbuttonHover) {
		myButton.addMouseListener(listenForbuttonHover);
	}

	public void disableUndo() {
		this.mntmUndo.setEnabled(false);
	}

	public void enableUndo() {
		this.mntmUndo.setEnabled(true);
		
	}

	public void disableRedo() {
		this.mntmRedo.setEnabled(false);
		
	}

	public void enableRedo() {
		this.mntmRedo.setEnabled(true);
		
	}
	
	public void userGuideListener(ActionListener listenForUserGuide) {
		mntmUserGuide.addActionListener(listenForUserGuide);
	}
	
	class buttonHover implements MouseListener {

		@Override
		public void mouseEntered(MouseEvent evt) {
			((JButton) evt.getSource()).setBackground(new Color(232, 239, 247));
			((JButton) evt.getSource()).setBorderPainted(true);
		}

		@Override
		public void mouseExited(MouseEvent evt) {
			((JButton) evt.getSource()).setBackground(new Color(245, 246, 247));
			((JButton) evt.getSource()).setBorderPainted(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
}
