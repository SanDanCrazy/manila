package manila.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import manila.controller.DiceController;
import manila.controller.GameController;
import manila.model.Boat;
import manila.model.Game;
import manila.model.Position;

/**
 * 游戏场景界面类
 */
public class PlaygroundView extends JPanel {
	
	/** 小船1的JLabel */
	private JLabel boat1;
	/** 小船2的JLabel */
	private JLabel boat2;
	/** 小船3的JLabel */
	private JLabel boat3;
	/** 大海贴图的JLabel */
	private JLabel seaLabel;
	/** 保险员贴图的JLabel */
	private JLabel insuranceLabel;
	/** 大领航员贴图的JLabel */
	private JLabel pilotLabel1;
	/** 小领航员贴图的JLabel */
	private JLabel pilotLabel2;
	/** 修理厂贴图的JLabel */
	private JLabel repairLabel;
	/** 港口贴图的JLabel */
	private JLabel portLabel;
	/** 海盗船贴图的JLabel */
	private JLabel pirateLabel;
	/** 控制船前进的Button */
	private JButton diceButton;
	
	/** 大海的JPanel(其中包含三个小船的JLabel和大海图  */
	private JPanel seaPanel;
	/** 保险员的JPanel */
	private JPanel insurancePanel;
	/** 领航员的JPanel */
	private JPanel pilotPanel;
	/** 修理厂的JPanel */
	private JPanel repairPanel;
	/** 港口的JPanel */
	private JPanel portPanel;
	/** 控制船前进的JPanel */
	private JPanel dicePanel;
	/** 海盗的JPanel */
	private JPanel piratePanel;

	
	
	private Game game;
	
	public PlaygroundView(Game g){
		this.game = g;
		this.setBounds(660, 0, 1022, 853);
		this.addMouseListener(new GameController(this.game));
		
		this.initComponents();//贴图工作未完成
		
		this.add(dicePanel);
		this.add(insurancePanel);
		this.add(pilotPanel);
		this.add(piratePanel);
		this.add(portPanel);
		this.add(repairPanel);
		this.add(seaPanel);
		
	}
	
	/**
	 * 对组件的位置进行初始化
	 */
	private void initComponents() {
		
		//大海的JPanel初始化
		this.seaPanel = new JPanel();
		this.seaLabel = new JLabel();
		this.seaPanel.setBounds(0, 211, 1008, 346);
		this.seaLabel.setBounds(0, 211, 1008, 346);
		this.seaPanel.add(seaLabel);
		this.boat1 = new JLabel();
		this.boat1.setBounds(0, 39, 188, 54);
		this.boat2 = new JLabel();
		this.boat2.setBounds(0, 144, 188, 54);
		this.boat3 = new JLabel();
		this.boat3.setBounds(0, 252, 188, 54);
	
		//保险员的JPanel初始化
		this.insurancePanel = new JPanel();
		this.insuranceLabel = new JLabel();
		this.insurancePanel.setBounds(103, 28, 122, 120);
		this.insuranceLabel.setBounds(103, 28, 122, 120);
		this.insurancePanel.add(insuranceLabel);
		
		//领航员的JPanel初始化
		this.pilotPanel = new JPanel();
		this.pilotLabel1 = new JLabel();
		this.pilotLabel2 = new JLabel();
		this.pilotPanel.setBounds(448, 40, 190, 81);
		this.pilotLabel1.setBounds(448, 40, 95, 41);
		this.pilotLabel2.setBounds(448, 40, 95, 40);
		this.pilotPanel.add(pilotLabel1);
		this.pilotPanel.add(pilotLabel2);
		
		//修理厂的JPanel初始化
		this.repairPanel = new JPanel();
		this.repairLabel = new JLabel();
		this.repairPanel.setBounds(268, 584, 402, 193);
		this.repairLabel.setBounds(268, 584, 402, 193);
		this.repairPanel.add(repairLabel);
		
		//港口的JPanel初始化
		this.portPanel = new JPanel();
		this.portLabel = new JLabel();
		this.portPanel.setBounds(730, 580, 234, 273);
		this.portLabel.setBounds(730, 580, 234, 273);
		this.portPanel.add(portLabel);
		
		//控制船前进的JPanel初始化
		this.dicePanel = new JPanel();
		this.diceButton = new JButton("前进");
		this.dicePanel.setBounds(54, 595, 144, 71);
		this.diceButton.setFont(new Font("宋体", Font.BOLD, 15));
		this.diceButton.setBounds(14, 13, 113, 45);
		this.diceButton.addActionListener(new DiceController(this.game));
		this.dicePanel.add(diceButton);
		
		//海盗的JPanel初始化
		this.piratePanel = new JPanel();
		this.pirateLabel = new JLabel();
		this.piratePanel .setBounds(832, 5, 109, 193);
		this.pirateLabel .setBounds(832, 5, 109, 193);
		this.piratePanel.add(pirateLabel);
		
		
	}

	
	
	
}
