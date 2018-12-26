package GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import restaurantSimulator.*;

public class GUIProgress  {   
	private WaitingLines waitingLines;
	private Progress progress;
	
	//나중에 패널 이용해서 바꾸겠음
	//일단 꾸미는 것 보단 구현 우선
   
	String cuswaitline, paywaitline, ordreqline, clerkwaitline, cleantable, payhandleclerk, reqhandleclerk, compressiondegree;
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
	ActionListener viewResult = e -> {
		int size = waitingLines.getCustomerWaitingLine().getListSize();
		List<Integer> cusCountList = waitingLines.getCustomerWaitingLine().getCountList();
		List<Customer> cusWaitList = waitingLines.getCustomerWaitingLine().getWaitList();
		for(int count = 0; count < size; count++) {
			cusCountList.add(cusWaitList.get(count).getCusWaitTime());
		}
		new ResultWindow(frame);
		progress.end();
		frame.setVisible(false);
		frame.setVisible(true);
	};
	
	public GUIProgress  (GUIMain frame) {
		this.frame = frame;
		this.frame.setContentPane(simulationMainScreen);
		waitingLines = new WaitingLines();
		//clerkwaitline = String.valueOf();
		progress = Progress.getInstance();
		progress.init();
		
		compressiondegree = String.valueOf(Option.customerPressure);
		init();
		view();
		new Thread(){
			@Override
			public void run(){
				while(true) {
					callcustomer();
					settext();
					//12-24 9시
					for(int i=0;i<Option.tableNumber;i++) {
						if(waitingLines.getCustomerWaitingLine().getListSize()>0)
							cusToTable(i);
					}	
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}  
			}
		}.start();
		progress.progressStart();
	}
	public void callcustomer() {
		RestaurantTask task = new RestaurantTask();
		task.customerCreate();
		cuswaitline = String.valueOf(waitingLines.getCustomerWaitingLine().getListSize());
	}	
	//12-24 9시
	public void cusToTable(int i) {
		RestaurantTask task = new RestaurantTask();
		Table tmp = progress.getTable(i+1).getTableStatus();
		// if(tableArray[i]==Progress.getInstance().getTable(i).getTableStatus().getTableState().toString()) {
		if(tableArray[i].equals(TableState.isEmpty.toString())) {
			task.customertotable(tmp);
			tableArray[i]=tmp.getTableState().toString();
			task.addOrderLine(tmp);
			//task.addOrderLine(Progress.getInstance().getTable(i).getTableStatus());
			
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
		cleanTable.setText("테이블 정리 직원  :" + cleantable);
		payHandleClerk.setText("결제 처리 직원 :" + payhandleclerk);
		reqHandleClerk.setText("요청 처리 직원 :" + reqhandleclerk);
		compressionDegree.setText("압박 정도 :" + compressiondegree);
		
		for(int i=0; i<Option.tableNumber;i++) {
			table[i].setText("테이블"+(i+1)+":"+ tableArray[i]);
		}
	}
	//직원관련
//	public void clerkwait(){
//		clerkwaitline = String.valueOf()
//	}
   
//	public void clerkcreate() {
//		for(int i=0;i<Option.clerkNumber;i++) {
//			Runnable clerk = new ClerkThread(0,0); // 스레드에 시킬일이 포함된 runnable구현 클래스
//			Thread clerkthread = new Thread(clerk);
//		}
//	}
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
      
//      for(int i = 0; i<10 ; i++)
//      simulationMainScreen.add(table[i]);      
	}
}