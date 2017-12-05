package manila.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import manila.model.Cargo;

public class CargoView extends JPanel{

	/** 显示“货物价格”的JLabel */
	private JLabel label;
	/** 显示货物列表的文本区域 */
	private JTextArea textArea;
	/** 显示玉价格的JLabel */
	private JLabel label1;
	/** 显示人参价格的JLabel */
	private JLabel label2;
	/** 显示丝绸价格的JLabel */
	private JLabel label3;
	/** 显示肉豆蔻价格的JLabel */
	private JLabel label4;
	
	public CargoView() {
		this.label = new JLabel("货物价格");
		this.label.setFont(new Font("宋体", Font.BOLD, 30));
		this.label.setBounds(24, 13, 139, 41);
		
		this.textArea = new JTextArea();
		this.textArea.setBackground(UIManager.getColor("Button.background"));//background可以更改
		this.textArea.setFont(new Font("宋体", Font.BOLD, 25));
		this.textArea.setText("玉：\r\n人参：\r\n丝绸：\r\n肉豆蔻：");
		this.textArea.setBounds(24, 67, 98, 130);
		
		this.label1 = new JLabel(0+"");
		this.label1.setFont(new Font("宋体", Font.BOLD, 20));
		this.label1.setBounds(147, 67, 44, 30);
		this.label2 = new JLabel(0+"");
		this.label2.setFont(new Font("宋体", Font.BOLD, 20));
		this.label2.setBounds(147, 99, 44, 30);
		this.label3 = new JLabel(0+"");
		this.label3.setFont(new Font("宋体", Font.BOLD, 20));
		this.label3.setBounds(147, 131, 44, 30);
		this.label4 = new JLabel(0+"");
		this.label4.setFont(new Font("宋体", Font.BOLD, 20));
		this.label4.setBounds(147, 162, 44, 30);
		
		this.add(label);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(textArea);
	}
	
	public void updateCargovalue() {
		
		this.label1.setText(Cargo.JADE.getValue()+"");
		this.label2.setText(Cargo.GINSENG.getValue()+"");
		this.label3.setText(Cargo.SILK.getValue()+"");
		this.label4.setText(Cargo.NUTMEG.getValue()+"");
		
	}
}
