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
	
	//揶쏄낯伊� 占쏙옙占쎌뵠占쎄돌 嚥≪뮄�у첎�늿占썲쳞占� 占쎄문占쎄쉐
	
	GUIMain frame;
	Container frameContentPane;
	
	JPanel startPanel = new JPanel(null);
	
	JButton startBtn = new JButton("시작하기");
	JButton optionBtn = new JButton("옵션");
	
	public GUIMain() {
		
		this("식당 시뮬레이터");
	}	
	
	public GUIMain(String name) {
		
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //占쎈늄占쎌쟿占쎌뿫占쎌벥 X�몴占� 占쎈땭占쏙옙占쎌뱽 占쎈뻻 �넫�굝利�
		setBounds(50, 50, 1500, 900); //占쎈늄占쎌쟿占쎌뿫占쎌뵠 占쎄돌占쏙옙占쎄돌占쎈뮉 占쎌맄燁살꼷占� 占쎄쾿疫뀐옙 筌욑옙占쎌젟
		setResizable(false); //占쎌넅筌롫똻�뱽 占쎈뮎占쎌뵠�⑨옙 餓κ쑴�뵬 占쎈땾 占쎈씨野껓옙 占쎈늄占쎌쟿占쎌뿫 占쎄쾿疫꿸퀡占쏙옙 �⑥쥙�젟占쎈뻻占쎄텚占쎈뼄.
		
		frameContentPane = getContentPane(); //占쎌겱占쎌삺 占쎄문占쎄쉐占쎈쭆 占쎈늄占쎌쟿占쎌뿫占쎌벥 �뚢뫂�쀯옙�뱜占쎈솴占쎌뱽 占쏙옙占쎌삢占쎈립占쎈뼄. 占쎌뵠 �뚢뫂�쀯옙�뱜 占쎈솴 占쎌맄占쎈퓠 �뚮똾猷뤄옙瑗놂옙�뱜占쎈굶占쎌뱽 add占쎈릭占쎈연 占쎌넅筌롫똻肉� 癰귣똻�뵠野껓옙 占쎈립占쎈뼄.
		frameContentPane.setLayout(null); //獄쏄퀣�뒄�꽴占썹뵳�딆쁽�몴占� null嚥∽옙! (占쎄땀揶쏉옙 �넫�슦紐닸에占� 筌띾뜆�벉占쏙옙嚥∽옙 占쎄퐬占쎌젟揶쏉옙占쎈뮟占쎈릭占쎈뼄.) //嚥≪뮄�젃占쎌뵥 占쎌넅筌롫똻占� �넫�슦紐닸에占� �뚮똾猷뤄옙瑗놂옙�뱜 占쎄퐬占쎌젟占쎈퉸癰귣챶�뼄!
		frameContentPane.setBackground(Color.white); //占쎄문占쎄쉐占쎈쭆 占쎈늄占쎌쟿占쎌뿫占쎌벥 獄쏄퀗瑗랃옙源뗰옙�뱽 占쎈릭占쏙옙占쎄퉳占쎌몵嚥∽옙 筌욑옙占쎌젟占쎈립占쎈뼄
		
		
		//甕곌쑵�뱣占쎈퓠 疫꿸퀡�뮟�빊遺쏙옙
		startBtn.addActionListener(new startProgress());
		optionBtn.addActionListener(new reviseOption());
		
		
		//占쎈늄占쎌쟿占쎌뿫 癰귣똻�뵠野껓옙 占쎈릭疫뀐옙
		setVisible(true);
		//甕곌쑵�뱣占쎌뵠 占쎈뼖疫뀐옙 占쎌겫占쎈열 �빊�뮆�젾
		selectOptionView();
	}	
	
	public void selectOptionView() {
		
		//甕곌쑵�뱣占쎌뱽 占쎄퐫占쎈선餓ο옙 占쎌겫占쎈열 占쎄퉳 筌욑옙占쎌젟 獄쏉옙 占쎈�믭옙紐®뵳占�
		startPanel.setForeground(Color.white);
		startPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		
		//占쎌겫占쎈열 占쎄텢占쎌뵠筌앾옙 筌욑옙占쎌젟
		startPanel.setBounds(395, 295, 400, 200);
		
		//�뚢뫂�쀯옙�뱜 占쎈솴占쎈퓠 占쎌겱占쎌삺 占쎈솭占쎄섯 �빊遺쏙옙
		frameContentPane.add(startPanel);
		
		//揶쏉옙 甕곌쑵�뱣 占쎄텢占쎌뵠筌앾옙 獄쏉옙 占쎌맄燁삼옙 筌욑옙占쎌젟

		startBtn.setBounds(160, 25, 80, 35);
		optionBtn.setBounds(160, 85, 80, 35);
		
		//占쎈솭占쎄섯占쎈퓠 甕곌쑵�뱣 �빊遺쏙옙
		startPanel.add(startBtn);
		startPanel.add(optionBtn);

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
}
  