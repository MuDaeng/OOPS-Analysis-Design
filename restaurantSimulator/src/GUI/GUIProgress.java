package GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import restaurantSimulator.*;

import waitingLine.WaitingLineEnum;

public class GUIProgress  {   
	private WaitingLines waitingLines;
	private Progress progress;
	
	//나중에 패널 이용해서 바꾸겠음
	//일단 꾸미는 것 보단 구현 우선
   
	String cuswaitline, paywaitline, ordreqline, clerkwaitline, cleantable = "", payhandleclerk = "", reqhandleclerk = "", compressiondegree;
	String[] tableArray = new String[Option.tableNumber];
   
 
	GUIMain frame;
	JPanel simulationMainScreen = new JPanel(null);
	JLabel cusWaitLine = new JLabel();
	JLabel payWaitLine = new JLabel();
	JLabel ordReqLine = new JLabel();
	JLabel clerkWaitLine = new JLabel();
	JLabel cleanTable = new JLabel();
	JLabel payHandleClerk = new JLabel();
	JLabel reqHandleClerk = new JLabel();
	JLabel[] table = new JLabel[Option.tableNumber];
	JLabel compressionDegree = new JLabel();
	JButton viewResultBtn = new JButton("마감");
	Thread callProgress;
	ActionListener viewResult = actionPerformed -> {
		int size = waitingLines.getCustomerWaitingLine().getListSize();
		List<Integer> cusCountList = waitingLines.getCustomerWaitingLine().getCountList();
		List<Customer> cusWaitList = waitingLines.getCustomerWaitingLine().getWaitList();
		for(int count = 0; count < size; count++) {
			cusCountList.add(cusWaitList.get(count).getCusWaitTime());
		}
		size = waitingLines.getClerkWaitingLine().getListSize();
		List<Integer> clerkCountList = waitingLines.getClerkWaitingLine().getCountList();
		List<Clerk> clerkWaitList = waitingLines.getClerkWaitingLine().getWaitList();
		for(int count = 0; count < size-1; count++) {
			clerkCountList.add(clerkWaitList.get(count).getClerkWaitTime());
		}

		progress.end();
		callProgress.interrupt();
		new ResultWindow(frame);
		frame.setVisible(false);
		frame.setVisible(true);
	};

	public GUIProgress  (GUIMain frame) {
		this.frame = frame;
		this.frame.setContentPane(simulationMainScreen);
		callProgress = new Thread(() -> {
			while(true) {
				callcustomer();
				catchWorking();
				settext();
				for(int count = 0; count < progress.getTables().length; count++) {
					 tableArray[count]= progress.getTable(count+1).getTableStatus().getTableState().toString();		
				}
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					// TODO Auto-generated catch block
					break;
				}
			}
		});
		waitingLines = new WaitingLines();
		progress = Progress.getInstance();
		progress.init();
		
		compressiondegree = String.valueOf(Option.customerPressure);
		
		init();
		view();
		progress.progressStart();
		callProgress.start();
	}
	private void callcustomer() {
		cuswaitline = String.valueOf(waitingLines.getCustomerWaitingLine().getListSize());
	}
	//12-24 9시
	private void catchWorking() {
		int size = progress.getClerks().length;
		for(int count = 0; count < size; count++) {
			Clerk clerk = progress.getClerk(count+1).getClerkStatus();
			String clerkNum = String.valueOf(clerk.getClerkNum());
			if(clerk.getClerkState() == ClerkState.takePayment) {
				if(!(payhandleclerk.contains(clerkNum))) payhandleclerk += clerkNum + ",";
			}else if(clerk.getClerkState() == ClerkState.takeOrder) {
				if(!(reqhandleclerk.contains(clerkNum))) reqhandleclerk += clerkNum + ",";
			}else if(clerk.getClerkState() == ClerkState.takeClearTable) {
				if(!(cleantable.contains(clerkNum))) cleantable += clerkNum + ",";
			}else {
				if(payhandleclerk.contains(clerkNum)) {
					payhandleclerk = payhandleclerk.replace(clerkNum+",", "");
				}else if(reqhandleclerk.contains(clerkNum)) {
					reqhandleclerk = reqhandleclerk.replaceAll(clerkNum+",", "");
				}else if(cleantable.contains(clerkNum)) {
					cleantable = cleantable.replace(clerkNum+",","");
					
				}
			}
		}
	}
	//12-24 9시
	public void init() {
		for(int i=0;i<progress.getTables().length;i++)
			tableArray[i] = progress.getTable(i+1).getTableStatus().getTableState().toString();

		viewResultBtn.addActionListener(viewResult);
	}	
   
	private void settext() {
		clerkwaitline = String.valueOf(progress.getClerkWaitingLine().getListSize());
		cusWaitLine.setText("손님 대기 줄 :" + cuswaitline);
		payWaitLine.setText("결제 대기 줄 :" + paywaitline);
		ordReqLine.setText("요청 대기 줄 :" + ordreqline);
		clerkWaitLine.setText("직원 대기 줄 :" + clerkwaitline);
		cleanTable.setText("테이블 정리 직원  :" + ((cleantable.length() == 0)? cleantable : cleantable.substring(0,cleantable.length()-1)));
		payHandleClerk.setText("결제 처리 직원 :" + ((payhandleclerk.length() == 0)? payhandleclerk : payhandleclerk.substring(0, payhandleclerk.length()-1)));
		reqHandleClerk.setText("요청 처리 직원 :" + ((reqhandleclerk.length() == 0)? reqhandleclerk : reqhandleclerk.substring(0, reqhandleclerk.length()-1)));
		compressionDegree.setText("압박 정도 :" + compressiondegree);
		
		for(int i=0; i<Option.tableNumber;i++) {
			table[i].setText("테이블"+(i+1)+":"+ tableArray[i]);
		}
	}
	public void view() {  
		compressionDegree.setBounds(800, 20, 200, 100);
		cusWaitLine.setBounds(30, 50, 200, 100);
		payWaitLine.setBounds(30, 20, 200, 100);
		ordReqLine.setBounds(800, 300, 200, 100);
		clerkWaitLine.setBounds(800, 100, 200, 100);
		cleanTable.setBounds(1100, 300, 200, 100);
		payHandleClerk.setBounds(1100, 500, 200, 100);
		reqHandleClerk.setBounds(800, 500, 200, 100);
		viewResultBtn.setBounds(1200,600, 80, 80);	
		
		//이것좀 해결방법좀 알려주소
		for(int i=0;i<Option.tableNumber;i++)
		{
			table[i]=new JLabel();
		}
		for(int i=0;i<Option.tableNumber;i++) {
			table[i].setBounds((30+100*i), 500, 100, 50);
			if(i>4)
				table[i].setBounds((30+100*i-500),600,100,50);
		}
      
		simulationMainScreen.add(compressionDegree);
		simulationMainScreen.add(cusWaitLine);
		simulationMainScreen.add(payWaitLine);
		simulationMainScreen.add(ordReqLine);
		simulationMainScreen.add(clerkWaitLine);
		simulationMainScreen.add(cleanTable);
		simulationMainScreen.add(payHandleClerk);
		simulationMainScreen.add(reqHandleClerk);
		simulationMainScreen.add(viewResultBtn);
		
		for(int i=0;i<Option.tableNumber;i++) {
			simulationMainScreen.add(table[i]);
		}	    	
	}
}