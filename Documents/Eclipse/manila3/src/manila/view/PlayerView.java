package manila.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import manila.model.Cargo;
import manila.model.Player;
import manila.model.Stock;

/**
 * 玩家的信息展示界面
 */
public class PlayerView extends JPanel {
	
	/** 得分（账户余额）标签 */
	private JLabel scoreV;
	/** 玩家名称标签 */
	private JLabel nameV;
	/** 玩家的工人（海员）数 */
	private JLabel worker_nbV;
	/** 股份显示文本框 */
	private JTextArea stockTextArea;
	/** 玉股份持有数 */
	private JLabel label1;
	/** 人参股份持有数 */
	private JLabel label2;
	/** 丝绸股份持有数 */
	private JLabel label3;
	/** 肉豆蔻股份持有数 */
	private JLabel label4;
	
	/** 该界面对应的玩家对象引用 */
	private Player player;
	/** 第几个玩家的信息 */
	private int i;
	/** 玩家信息之间的间隔 */
	private static final int LENTH = 100;
	
	/** 当前面板是否显示边框 */
	private boolean active;
	
	/**
	 * 玩家视图构造函数
	 * @param p 玩家对象的引用
	 */
	public PlayerView(Player p,int i){
		this.active = false;
		
		this.player = p;
		this.i = i;
		this.setBounds(0, 60+i*LENTH, 366, 100);
		
		this.scoreV = new JLabel(this.player.getAccount_balance()+"$");
		this.scoreV.setBounds(92, 16, 72, 63);
		this.nameV = new JLabel(this.player.getName());
		this.nameV.setBounds(0, 13, 78, 73);
		this.worker_nbV = new JLabel(this.player.getWorker_nb()+"");//加个""使得括号里面内容变为字符串
		this.worker_nbV.setBounds(170, 23, 37, 46);
		
		this.scoreV.setFont(new Font("宋体", Font.BOLD, 30));
		this.nameV.setFont(new Font("宋体", Font.BOLD, 25));
		this.worker_nbV.setFont(new Font("宋体", Font.BOLD, 30));
		//初始化股份界面
		this.stockTextArea = new JTextArea();
		this.stockTextArea.setEditable(false);
		this.stockTextArea.setFont(new Font("宋体", Font.BOLD, 20));
		this.stockTextArea.setBackground(UIManager.getColor("Button.background"));
		this.stockTextArea.setBounds(216, 1, 78, 99);
		this.stockTextArea.setText("玉：\r\n人参：\r\n丝绸：\r\n肉豆蔻：");
		//初始股份持有数量
		this.label1 = new JLabel("0");
		this.label1.setBounds(308, 5, 44, 20);
		this.label1.setFont(new Font("宋体", Font.BOLD, 20));
		this.label2 = new JLabel("0");
		this.label2.setBounds(308, 29, 44, 20);
		this.label2.setFont(new Font("宋体", Font.BOLD, 20));
		this.label3 = new JLabel("0");
		this.label3.setBounds(308, 54, 44, 20);
		this.label3.setFont(new Font("宋体", Font.BOLD, 20));
		this.label4 = new JLabel("0");
		this.label4.setBounds(308, 77, 44, 20);
		this.label4.setFont(new Font("宋体", Font.BOLD, 20));
		
		
		
		this.add(this.nameV);
	
		this.add(this.scoreV);
		this.add(this.label1);
		this.add(this.label2);
		this.add(this.label3);
		this.add(this.label4);
		this.add(this.worker_nbV);
		this.add(this.stockTextArea);
		
	}
	
	public void setActive(boolean active) {
		this.active = active;
		if(active){
			this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
		else{
			this.setBorder(null);
		}
	}

	public void updateStocksNumView() {
		int a=0,b=0,c=0,d=0;
		for(Stock s : this.player.getStockList()) {
			if(s.getName().equals(Cargo.JADE.getName())) a+=1;
			if(s.getName().equals(Cargo.GINSENG.getName())) b+=1;
			if(s.getName().equals(Cargo.SILK.getName())) c+=1;
			if(s.getName().equals(Cargo.NUTMEG.getName())) d+=1;
		}
		this.label1.setText(a+"");
		this.label2.setText(b+"");
		this.label3.setText(c+"");
		this.label4.setText(d+"");
		
	}
	public JLabel getScoreV() {
		return scoreV;
	}

	public void setScoreV(JLabel scoreV) {
		this.scoreV = scoreV;
	}

	public JLabel getWorker_nbV() {
		return worker_nbV;
	}

	public void setWorker_nbV(JLabel worker_nbV) {
		this.worker_nbV = worker_nbV;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isActive() {
		return active;
	}

	
}
