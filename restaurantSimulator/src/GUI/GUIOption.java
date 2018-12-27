package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import restaurantSimulator.Option;
import restaurantSimulator.TimeOperation;

public class GUIOption {
	GUIMain frame;
	JPanel optionScreen = new JPanel(null);
	JLabel customerpressureLabel = new JLabel("압박정도 :");
	JTextField pressureText = new JTextField("");
	
	JLabel clerknumberLabel = new JLabel("점원 수 :");
	JTextField clerknumberText = new JTextField("");
	
	JLabel tablenumberLabel = new JLabel("테이블 수 :");
	JTextField tablenumberText = new JTextField("");
	
	JButton toMain = new JButton("메인으로");
	TimeOperation timeOperation;
	
	//setting frame from GUIMain and add actionListener of Button
	public GUIOption(GUIMain frame) {
		this.frame = frame;
		this.frame.setContentPane(optionScreen);
		this.timeOperation = TimeOperation.getInstance();
		toMain.addActionListener(new setOption());
		
		optionview();
	}
	//setting location of components in panel
	public void optionview() {
		customerpressureLabel.setBounds(500, 200, 150, 50);
		pressureText.setBounds(700, 200, 150, 50);
		
		clerknumberLabel.setBounds(500, 300, 150, 50);
		clerknumberText.setBounds(700, 300, 150, 50);
		
		tablenumberLabel.setBounds(500, 400, 150, 50);
		tablenumberText.setBounds(700, 400, 150, 50);
		
		toMain.setBounds(600, 500, 200, 100);
		
		optionScreen.add(customerpressureLabel);
		optionScreen.add(pressureText);
		optionScreen.add(clerknumberLabel);
		optionScreen.add(clerknumberText);
		optionScreen.add(tablenumberLabel);
		optionScreen.add(tablenumberText);
		optionScreen.add(toMain);	
	}	
	
	class setOption implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String customerPressureS, clerkNumberS, tableNumberS; 
			
			customerPressureS = pressureText.getText();
			clerkNumberS = clerknumberText.getText();
			tableNumberS = tablenumberText.getText();
			
			int customerPressureI = Integer.parseInt(customerPressureS);
			int clerkNumberI = Integer.parseInt(clerkNumberS);
			int tableNumberI = Integer.parseInt(tableNumberS);
			
			Option.customerPressure = customerPressureI;
			Option.clerkNumber = clerkNumberI;
			Option.tableNumber = tableNumberI;
			frame.dispose();
			new GUIMain();		
		}	      
	}
}