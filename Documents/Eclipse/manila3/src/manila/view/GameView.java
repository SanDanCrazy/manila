package manila.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import manila.controller.DiceController;
import manila.model.Game;
import manila.model.Player;

/**
 * 游戏主界面，包含main函数
 */
public class GameView extends JPanel {
	
	private Game game;
	
	/** 游戏场景窗口 */
	private PlaygroundView playground;
	
	/** 玩家信息窗口 */
	private JPanel playersView;
	
	/** 货物价格信息窗口 */
	private CargoView cargoV;
	
	/** 选择上场小船窗口 */
	private ChoosingBoatView choosingBoatV;
	
	/** 竞选海港负责人窗口 */
	private ChoosingBossView choosingBossV;
	
	/** 显示当前信息的窗口 */
	private CurrentStateView stateV;
	
	/** 存放玩家信息视图的数组 */
	private PlayerView[] playersV;
	
	
	
	public GameView(){
		this.game = new Game(this);
		
		this.playground = new PlaygroundView(this.game);
       
        this.cargoV = new CargoView();
        
        this.makePlayerView();
        
        
	}
	
	/**
	 * 对玩家信息视图进行初始化
	 */
	public void makePlayerView(){
		this.playersView = new JPanel();
		this.playersView.setLayout(null);
		this.playersView.setBounds(0, 0, 366, 460);
		
		JLabel text = new JLabel("玩家信息");
		text.setBounds(97, 13, 139, 41);
		text.setFont(new Font("宋体", Font.BOLD, 30));
		this.playersView.add(text);
		
		Player[] players = this.game.getPlayers();
		this.playersV = new PlayerView[players.length];
		for(int i=0; i<players.length; i++){
			PlayerView pv = new PlayerView(players[i],i);
			if(this.game.getCurrent_pid() == players[i].getPid()){
				pv.setActive(true);
			}
			this.playersV[i] = pv;
			this.playersView.add(pv);
		}
	}
	
	/**
	 * 对玩家的显示在界面上的相关信息进行更新
	 * @param pid 对应玩家的ID
	 * @param active 是否标记此玩家为当前玩家
	 */
	public void updatePlayersView(int pid, boolean active){
		for(PlayerView pv : this.playersV){
			Player p = pv.getPlayer();
			if(p.getPid() == pid){
				if(!active){
					pv.getScoreV().setText(p.getAccount_balance()+"$");
					pv.getWorker_nbV().setText(p.getWorker_nb()+"");
					pv.updateStocksNumView();
				}
				pv.setActive(active);
			}
			
		}
	}
	

	//getter and setter and the last is main
	public PlaygroundView getPlayground() {
		return playground;
	}

	public void setPlayground(PlaygroundView playground) {
		this.playground = playground;
	}

	public JPanel getPlayersView() {
		return playersView;
	}

	public void setPlayersView(JPanel playersView) {
		this.playersView = playersView;
	}

	public PlayerView[] getPlayersV() {
		return playersV;
	}

	public void setPlayersV(PlayerView[] playersV) {
		this.playersV = playersV;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mw = new JFrame();
		mw.setTitle("Manila");
		GameView gv = new GameView();
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.setContentPane(gv);
		mw.pack();
		mw.setVisible(true);
		
		ChoosingBossView cbv = new ChoosingBossView(gv.game);
	}
	
}
