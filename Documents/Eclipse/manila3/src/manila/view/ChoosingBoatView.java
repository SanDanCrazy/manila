package manila.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manila.controller.ChoosingBoatController;
import manila.model.Game;

public class ChoosingBoatView extends JPanel{
	private Game game;
	
	private ChoosingBoatController cbc;
	
	/** 复选框数组 */
	private JCheckBox[] checkboxes;
	/** 数字输入框数组 */
	private JTextField[] numAreas;
	/** 确定按钮 */
	private JButton button;
	
	private static int BOATNUM = 0;
	
	public ChoosingBoatView(Game g) {
		this.game = g;
		
		this.cbc = new ChoosingBoatController(this);
		
		this.setBounds(367, 227, 293, 233);
		this.setLayout(null);
		
		this.checkboxes = new JCheckBox[4];
		this.numAreas = new JTextField[4];
		for(int i =0; i<this.checkboxes.length; i++) {
			this.checkboxes[i] = new JCheckBox();
			this.checkboxes[i].setFont(new Font("宋体", Font.BOLD, 25));
			this.checkboxes[i].addActionListener(this.cbc);
			this.numAreas[i] = new JTextField();
			this.numAreas[i].setFont(new Font("宋体", Font.BOLD, 25));
			this.numAreas[i].setColumns(10);
			this.numAreas[i].addActionListener(this.cbc);
		}
		
		this.checkboxes[0].setText("玉");
		this.checkboxes[0].setBounds(10, 9, 118, 43);
		this.checkboxes[1].setText("人参");
		this.checkboxes[1].setBounds(10, 62, 118, 43);
		this.checkboxes[2].setText("丝绸");
		this.checkboxes[2].setBounds(10, 122, 118, 43);
		this.checkboxes[3].setText("肉豆蔻");
		this.checkboxes[3].setBounds(10, 182, 132, 43);
		
		this.numAreas[0].setBounds(150, 14, 50, 32);
		
		this.numAreas[1].setBounds(150, 67, 50, 32);
		
		this.numAreas[2].setBounds(150, 127, 50, 32);
		
		this.numAreas[3].setBounds(150, 187, 50, 32);
		
		this.button = new JButton("确定");
		this.button.setBounds(207, 9, 72, 210);
		

	}
	
	
}
