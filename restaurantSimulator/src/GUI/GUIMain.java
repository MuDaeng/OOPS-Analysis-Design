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
	
	//각종 틀이나 로고같은거 생성
	
	GUIMain frame;
	Container frameContentPane;
	
	JPanel startPanel = new JPanel(null);
	
	JButton startBtn = new JButton("시작");
	JButton optionBtn = new JButton("옵션설정");
	JButton resultBtn = new JButton("결과창");
	
	public GUIMain() {
		
		this("식당시뮬레이션");
	}	
	
	public GUIMain(String name) {
		
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임의 X를 눌렀을 시 종료
		setBounds(50, 50, 1500, 900); //프레임이 나타나는 위치와 크기 지정
		setResizable(false); //화면을 늘이고 줄일 수 없게 프레임 크기를 고정시킨다.
		
		frameContentPane = getContentPane(); //현재 생성된 프레임의 컨텐트팬을 저장한다. 이 컨텐트 팬 위에 컴포넌트들을 add하여 화면에 보이게 한다.
		frameContentPane.setLayout(null); //배치관리자를 null로! (내가 좌표로 마음대로 설정가능하다.) //로그인 화면은 좌표로 컴포넌트 설정해본다!
		frameContentPane.setBackground(Color.white); //생성된 프레임의 배경색을 하얀색으로 지정한다
		
		
		//버튼에 기능추가
		startBtn.addActionListener(new startProgress());
		optionBtn.addActionListener(new reviseOption());
		resultBtn.addActionListener(new readResult());
		
		
		//프레임 보이게 하기
		setVisible(true);
		//버튼이 담긴 영역 출력
		selectOptionView();
	}	
	
	public void selectOptionView() {
		
		//버튼을 넣어줄 영역 색 지정 및 테두리
		startPanel.setForeground(Color.white);
		startPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		
		//영역 사이즈 지정
		startPanel.setBounds(395, 295, 400, 200);
		
		//컨텐트 팬에 현재 패널 추가
		frameContentPane.add(startPanel);
		
		//각 버튼 사이즈 및 위치 지정

		startBtn.setBounds(160, 25, 80, 35);
		optionBtn.setBounds(160, 85, 80, 35);
		resultBtn.setBounds(160, 145, 80, 35);
		
		//패널에 버튼 추가
		startPanel.add(startBtn);
		startPanel.add(optionBtn);
		startPanel.add(resultBtn);
	}
	class startProgress implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			TimeOperation.getInstance().inputOptionToResultDTO(Option.customerPressure, Option.clerkNumber);
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
	class readResult implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			new ResultWindow(GUIMain.this);
			setVisible(false);
			setVisible(true);
		} 
	}
}
  