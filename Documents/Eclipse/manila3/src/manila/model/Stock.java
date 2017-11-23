package manila.model;


/**
 * 股份类，可以对股份进行买卖。 
 * @author SanDan
 */
public class Stock{
	/** 股份名字 */
	private String name;
	/** 股份价值 */
	private int stock_value;
	/** 股份是否被抵押 */
	private boolean mortgage;
	/** 股份被抵押时价格为15元 */
	public static final int STOCK_MORT_VALUE = 15;
	/** 一张股份可以换成12元 */
	public static final int STOCK_TO_MONEY = 12;
	
	public Stock(String n, int v) {
		this.setName(n);
		this.setStock_value(v);
		this.setMortgage(false);
	}
	
	//getter and setter
	public boolean isMortgage() {
		return mortgage;
	}

	public void setMortgage(boolean mortgage) {
		this.mortgage = mortgage;
	}

	public int getStock_value() {
		return stock_value;
	}

	public void setStock_value(int stock_value) {
		this.stock_value = stock_value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
