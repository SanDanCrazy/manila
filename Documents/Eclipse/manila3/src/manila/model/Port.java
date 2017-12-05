package manila.model;

import manila.view.PlaygroundView;

/**
 * 港口类，若有成功到达港口的小船就可以获利 
 * @author SanDan
 */
public class Port implements GetOnPosition{
	
	private Position position;
	/** 港口名称 */
	private String name;
	/** 港口停船时为true，反之为false */
	private boolean beFulled;
	/** 港口可获利金额 */
	private int port_value;
	
	
	
	private int posX;
	private int posY;
	
	public Port(Position p, String n,int v) {
		this.position = p;
		this.setName(n);
		this.setPort_value(v);
		this.beFulled = false;
	}
	/**
	 * 船靠岸，beFulled为true
	 */
	public void berthBoat() {
		this.beFulled = true;
	}
	
	//getter and setter
	public boolean getBeFulled() {
		return this.beFulled;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort_value() {
		return port_value;
	}

	public void setPort_value(int port_value) {
		this.port_value = port_value;
	}

	@Override
	public void getOnboard(int pid) {
		if(getAvailPosIndex() == 0) this.position.setSailorID(pid);
	}

	@Override
	public int getAvailPosIndex() {
		if(this.position.getSailorID() == -1)
			return 0;
		// no position left
		return -1;
	}

	@Override
	public int getFilledPosNum() {
		int pos_ind = getAvailPosIndex();
		if(pos_ind == -1)
			return 1;
		else
			return pos_ind;
	}

	@Override
	public int getAvailPosPrice() {
		if(this.position.getSailorID() == -1)
			return this.position.getPrice();
		return -1;
	}

	
	
}
