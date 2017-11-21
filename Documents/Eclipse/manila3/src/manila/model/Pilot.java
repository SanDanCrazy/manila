package manila.model;

import manila.view.PlaygroundView;

/**
 * 领航员类，可以在特定情况移动小船。 
 * @author SanDan
 * isCursorInside未修改
 */
public class Pilot implements GetOnPosition{
	/** 空位数组 */
	private Position[] pos_list;
	/** 是否为大领航员 */
	private boolean pilot_leader;
	/** 领航员拥有的影响力 */
	private int influence;
	
	/** 领航员在图形界面的左上角的X坐标 */
	private int posX;
	/** 领航员在图形界面的左上角的Y坐标 */
	private int posY;
	
	public Pilot(Position[] p) {
		this.pos_list = p;
		this.setPilot_leader(false);
		this.setInfluence(1);
	}
	
	
	public void setPilotLeader() {
		this.setPilot_leader(true);
		this.setInfluence(2);
	}
	
	public int getInfluence() {
		return influence;
	}


	public void setInfluence(int influence) {
		this.influence = influence;
	}


	public boolean isPilot_leader() {
		return pilot_leader;
	}


	public void setPilot_leader(boolean pilot_leader) {
		this.pilot_leader = pilot_leader;
	}
	@Override
	public void getOnboard(int pid) {
		if(getAvailPosIndex() == 0) {
			this.setPilotLeader();
			this.pos_list[getAvailPosIndex()].setSailorID(pid);
		}
		else this.pos_list[getAvailPosIndex()].setSailorID(pid);
		
	}

	@Override
	public int getAvailPosIndex() {
		for(int i=0; i<this.pos_list.length; i++){
			if(this.pos_list[i].getSailorID() == -1)
				return i;
		}
		// no position left
		return -1;
	}

	@Override
	public int getFilledPosNum() {
		int pos_ind = getAvailPosIndex();
		if(pos_ind == -1)
			return this.pos_list.length;
		else
			return pos_ind;
	}

	@Override
	public int getAvailPosPrice() {
		for(int i=0; i<this.pos_list.length; i++){
			if(this.pos_list[i].getSailorID() == -1)
				return this.pos_list[i].getPrice();
		}
		return -1;
	}

	@Override
	public boolean isCursorInside(int x, int y) {
		if(x > this.posX && x < this.posX+PlaygroundView.BOAT_W
				&& y > this.posY && y< this.posY+PlaygroundView.BOAT_H)
			return true;
		return false;
	}


	
	
}
