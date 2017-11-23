package manila.model;

/**
 * 玩家类，包含玩家的姓名等基本信息。
 */
import java.awt.Color;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Player {
	/** 玩家名 */
	private String name;
	/** 玩家的ID */
	private int pid;
	/** 账户余额 */
	private int account_balance;
	/** 股份集合 */
	private ArrayList<Stock> stocks;
	/** 玩家拥有的工人（海员）数 */
	private int worker_nb;
	/** 玩家所对应的颜色 */
	private Color c;
	
	
	/**
	 * 玩家构造函数
	 * @param name 玩家姓名
	 * @param pid 玩家ID
	 * @param c 玩家分配的颜色
	 */
	public Player(String name, int pid, Color c){
		this.name = name;
		this.pid = pid;
		this.account_balance = 30;
		this.c = c;
		this.worker_nb = Game.ROUND_NUMBER;
		this.stocks = new ArrayList<Stock>();
	}

	/**
	 * 分配收益时调用的函数
	 * @param profit 为玩家分配的收益，放入余额中
	 */
	public void receiveProfit(int profit){
		this.account_balance += profit;
	}
	/**
	 * 玩家选择股份并且卖掉
	 */
	public void sellStock(Stock stock_name) {
		receiveProfit(Stock.STOCK_TO_MONEY);
		stocks.remove(stock_name);
	}
	/**
	 * 玩家将抵押的股份变为未抵押,并且对玩家拥有的股份按照中文名排序
	 */
	public void changeStock(Stock stock) {
		if(this.getAccount_balance() >= Stock.STOCK_MORT_VALUE) {
			stocks.add(stock);
			this.receiveProfit(-Stock.STOCK_MORT_VALUE);
		Collections.sort(stocks, new Comparator<Stock>() {

			@Override
			public int compare(Stock a1, Stock a2) {
				Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
				return cmp.compare(a1.getName(), a2.getName());
			}
			
		});}
		else System.out.println("你将这个股份变成未抵押");
	}
	/**
	 * 成功竞选海港负责人的玩家购买股份
	 */
	public void buyStock(Stock stock) {
		if(this.getAccount_balance() >= stock.getStock_value()) {
			stocks.add(stock);
			this.receiveProfit(-stock.getStock_value());
			Collections.sort(stocks, new Comparator<Stock>() {

				@Override
				public int compare(Stock a1, Stock a2) {
					Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
					return cmp.compare(a1.getName(), a2.getName());
				}
				
			});}
	}
	
	public void getWelfare() {
		this.account_balance += InsuranceOfficer.WELFARE;
	}
	
	public void payPos(int amount){
		this.account_balance -= amount;
		this.worker_nb--;
	}
	
	//getter and setter
	/** 初始化玩家的股份数组 */
	public void setStockList(ArrayList<Stock> s) {
		this.stocks = s;
	}
	public ArrayList<Stock> getStockList(){
		return stocks;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}

	public int getWorker_nb() {
		return worker_nb;
	}

	public void setWorker_nb(int worker_nb) {
		this.worker_nb = worker_nb;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
}
