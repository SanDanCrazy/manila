package manila.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import manila.controller.ChoosingBossController;
import manila.model.Game;
import manila.model.Player;

/**
 * Manila 游戏选举船老大的窗口。
 */
public class ChoosingBossView extends JPanel {
	private Game game;
	
	private ChoosingBossController cbc;
	
	/** 主面板 */
	private JPanel content;
	/** 玩家1姓名的label */
	private JLabel name1Label;
	/** 玩家2姓名的label */
	private JLabel name2Label;
	/** 玩家3姓名的label */
	private JLabel name3Label;
	/** 玩家4姓名的label */
	private JLabel name4Label;
	/** 当前竞选海港负责人的金额 */
	private JLabel moneyLabel;
	/** 显示当前海港负责人的label */
	private JLabel bossLabel;
	
	/** 竞选金额输入框 */
	private JTextField amountT;
	/** 竞选按钮 */
	private JButton bidB;
	/** 跳过本轮竞选按钮 */
	private JButton passB;
	
	/** 简略版PlayerView的数组 */
	private PlayerView[] pvList;
	
	public ChoosingBossView(Game g){
		this.game = g;
		this.cbc = new ChoosingBossController(this);
		
		this.content = new JPanel();
		this.content.setBounds(0, 460, 425, 393);
		this.content.setLayout(null);
		
		this.pvList = new PlayerView[this.game.getPlayers().length];
		for(int i=0; i<this.game.getPlayers().length; i++){
			this.pvList[i] = new PlayerView(this.game.getPlayers()[i],i);
			if(i == 0){
				this.pvList[i].setActive(true);
			}
		}
		
		this.name1Label = new JLabel();
		this.name1Label.setText(this.game.getPlayers()[0].getName());
		this.name1Label.setFont(new Font("宋体", Font.BOLD, 25));
		this.name1Label.setBounds(0, 66, 78, 73);
		this.name2Label = new JLabel();
		this.name1Label.setText(this.game.getPlayers()[1].getName());
		this.name1Label.setFont(new Font("宋体", Font.BOLD, 25));
		this.name1Label.setBounds(100, 66, 78, 73);
		this.name3Label = new JLabel();
		this.name1Label.setText(this.game.getPlayers()[2].getName());
		this.name1Label.setFont(new Font("宋体", Font.BOLD, 25));
		this.name1Label.setBounds(200, 66, 78, 73);
		this.name4Label = new JLabel();
		this.name1Label.setText(this.game.getPlayers()[3].getName());
		this.name1Label.setFont(new Font("宋体", Font.BOLD, 25));
		this.name1Label.setBounds(300, 66, 78, 73);
		
		
		JLabel label = new JLabel("海港负责人:");
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(51, 197, 156, 41);
		
		JLabel label1 = new JLabel("竞选窗口");
		label1.setFont(new Font("宋体", Font.BOLD, 30));
		label1.setBounds(131, 3, 134, 42);

		this.bossLabel = new JLabel("xxxx");
		this.bossLabel.setFont(new Font("宋体", Font.BOLD, 35));

		
		this.amountT = new JTextField();
		this.amountT.setFont(new Font("宋体", Font.BOLD, 25));
		this.amountT.setBounds(169, 267, 50, 32);
		this.amountT.setColumns(10);
		
		this.setMoneyLabel(new JLabel());
		
		this.bidB = new JButton("竞选");
		this.bidB.setFont(new Font("宋体", Font.BOLD, 15));
		this.bidB.setBounds(151, 327, 93, 27);
		this.passB = new JButton("跳过");
		this.passB.setFont(new Font("宋体", Font.BOLD, 15));
		this.passB.setBounds(285, 267, 93, 27);
		
		this.bidB.addActionListener(this.cbc);
		this.bidB.setActionCommand("bid");
		this.passB.addActionListener(this.cbc);
		this.passB.setActionCommand("pass");
		
	}

	public void updateBidView(int pid, boolean active){
		for(PlayerView pv : this.pvList){
			Player p = pv.getPlayer();
			if(p.getPid() == pid){
				pv.setActive(active);
			}
			
		}
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public JTextField getAmountT() {
		return amountT;
	}

	public void setAmountT(JTextField amountT) {
		this.amountT = amountT;
	}

	public PlayerView[] getPvList() {
		return pvList;
	}

	public void setPvList(PlayerView[] pvList) {
		this.pvList = pvList;
	}

	public JLabel getBossLabel() {
		return bossLabel;
	}

	public void setBossLabel(JLabel bossLabel) {
		this.bossLabel = bossLabel;
	}

	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	public void setMoneyLabel(JLabel moneyLabel) {
		this.moneyLabel = moneyLabel;
	}
	
	
}
