package manila.model;

import manila.view.PlaygroundView;

/**
 * 修理港类，若有到达修理港的小船就可获利 
 * @author SanDan
 */
public class RepairDepot implements GetOnPosition{
	
	private Position position;
	/** 修理港名称 */
	private String name;
	/** 修理港空位所获利润 */
	private int repair_value;
	/** 修理港是否停有小船 */
	private boolean fulled;
	
	private int posX;
	private int posY;
	
	public RepairDepot(Position p, String n, int v) {
		this.setPosition(p);
		this.setName(n);
		this.setRepair_value(v);
		this.setFulled(false);
	}

	
	//getter and setter
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getRepair_value() {
		return repair_value;
	}

	public void setRepair_value(int repair_value) {
		this.repair_value = repair_value;
	}

	public boolean isFulled() {
		return fulled;
	}

	public void setFulled(boolean fulled) {
		this.fulled = fulled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
