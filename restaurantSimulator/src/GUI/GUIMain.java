package GUI;



import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import restaurantSimulator.Option;
import restaurantSimulator.TimeOperation;

public class GUIMain extends JFrame {
	
	GUIMain frame;
	Container frameContentPane;
	
	JPanel startPanel = new JPanel(null);
	
	JButton startBtn = new JButton("시작하기");
	JButton optionBtn = new JButton("옵션");
	
	public GUIMain() {
		
		this("식당 시뮬레이터");
	}	
	//Setting of size of frame of GUI and add actionListener of Buttons
	public GUIMain(String name) {
		
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(50, 50, 1500, 900);
		setResizable(false);
		
		frameContentPane = getContentPane();
		frameContentPane.setLayout(null);
		frameContentPane.setBackground(Color.white);
		
		startBtn.addActionListener(new startProgress());
		optionBtn.addActionListener(new reviseOption());
		
		setVisible(true);
		selectOptionView();
	}	
	
	//setting location of components in panel
	public void selectOptionView() {
		
		startPanel.setForeground(Color.white);
		startPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		
		startPanel.setBounds(395, 295, 400, 200);
		
		frameContentPane.add(startPanel);
		
		startBtn.setBounds(160, 25, 80, 35);
		optionBtn.setBounds(160, 85, 80, 35);
		
		startPanel.add(startBtn);
		startPanel.add(optionBtn);

	}
	class startProgress implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			TimeOperation.getInstance().inputOptionToResultDTO(Option.customerPressure, Option.clerkNumber); //when it go to GUIProgress, input Options To Result
			new GUIProgress(GUIMain.this);      
			setVisible(false);
			setVisible(true);
		}  
	}
	class reviseOption implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new GUIOption(GUIMain.this);
			setVisible(false);
			setVisible(true);
		}	
   }
}
  