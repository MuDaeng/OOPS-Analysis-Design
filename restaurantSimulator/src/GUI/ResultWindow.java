package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import restaurantSimulator.ResultDTO;
import restaurantSimulator.TimeOperation;
import restaurantSimulator.WaitingLines;

public class ResultWindow {
   
	GUIMain frame;
	JPanel resultwindow = new JPanel(null);
	
	JLabel compressionDegree = new JLabel();
	JLabel customerNumber = new JLabel();
	JLabel clerkNumber = new JLabel();
	JLabel cusMaxWaitingTime = new JLabel();
	JLabel cusAvgWaitingTime = new JLabel();
	JLabel clerkMaxWaitingTime = new JLabel();
	JLabel clerkAvgWaitingTime = new JLabel();
	JLabel payMaxWaitingTime = new JLabel();
	JLabel payAvgWaitingTime = new JLabel();
	JLabel reqMaxWaitingTime = new JLabel();
	JLabel reqAvgWaitingTime = new JLabel();
	
	
	private TimeOperation timeOperation;
	private ResultDTO result;
	
	//setting frame and get Result
	public ResultWindow(GUIMain frame) {
		
		this.frame = frame;
		this.frame.setContentPane(resultwindow);
		
		timeOperation = TimeOperation.getInstance();
		timeOperation.inputResultToResultDTO();
		result = timeOperation.getResultDTO();
		resultview();      
	}	
	
	//setting there's text and location of them in panel
	public void resultview() {
		compressionDegree.setText("손님 압박 정도 : " + result.getCompressionDegree());
		customerNumber.setText("손님 수 : " + result.getCustomerNumber());
		clerkNumber.setText("직원 수 : " + result.getClerkNumber());
		cusMaxWaitingTime.setText("최대 손님 대기 시간 : " + result.getCusMaxWaitingTime());
		cusAvgWaitingTime.setText("평균 손님 대기 시간 : " + result.getCusAvgWaitingTime());
		clerkMaxWaitingTime.setText("최대 직원 대기 시간 : " + result.getClerkMaxWaitingTime());
		clerkAvgWaitingTime.setText("평균 직원 대기 시간 : " + result.getClerkAvgWaitingTime());
		payMaxWaitingTime.setText("최대 결제 대기 시간 : " + result.getPayMaxWaitingTime());
		payAvgWaitingTime.setText("평균 결제 대기 시간 : " + result.getPayAvgWaitingTime());
		reqMaxWaitingTime.setText("최대 요청 대기 시간 : " + result.getReqMaxWaitingTime());
		reqAvgWaitingTime.setText("평균 요청 대기 시간 : " + result.getReqAvgWaitingTime());
		
		compressionDegree.setBounds(500, 100, 300, 100);
		customerNumber.setBounds(500, 135, 300, 100);
		clerkNumber.setBounds(500, 170, 300, 100);
		cusMaxWaitingTime.setBounds(500, 205, 300, 100);
		cusAvgWaitingTime.setBounds(500, 240, 300, 100);
		clerkMaxWaitingTime.setBounds(500, 275, 300, 100);
		clerkAvgWaitingTime.setBounds(500, 310, 300 , 100);
		payMaxWaitingTime.setBounds(500, 345, 300, 100);
		payAvgWaitingTime.setBounds(500, 380, 300, 100);
		reqMaxWaitingTime.setBounds(500, 415, 300, 100);
		reqAvgWaitingTime.setBounds(500, 450, 300, 100);
		

		
		resultwindow.add(compressionDegree);
		resultwindow.add(customerNumber);
		resultwindow.add(clerkNumber);
		resultwindow.add(cusMaxWaitingTime);
		resultwindow.add(cusAvgWaitingTime);
		resultwindow.add(clerkMaxWaitingTime);
		resultwindow.add(clerkAvgWaitingTime);
		resultwindow.add(payMaxWaitingTime);
		resultwindow.add(payAvgWaitingTime);
		resultwindow.add(reqMaxWaitingTime);
		resultwindow.add(reqAvgWaitingTime);

		
	}	
	
	class returnMain implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			frame.dispose();
			new GUIMain();
		}	 
	}
}