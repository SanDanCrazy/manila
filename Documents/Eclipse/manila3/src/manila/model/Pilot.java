package manila.model;

import manila.view.PlaygroundView;

/**
 * 领航员类，可以在特定情况移动小船。 
 * @author SanDan
 * isCursorInside未修改
 */
public class Pilot implements GetOnPosition{
	/** 一个空位 */
	private Position position;
	/** 领航员拥有的影响力 */
	private int influence;
	
	/** 领航员在图形界面的左上角的X坐标 */
	private int posX;
	/** 领航员在图形界面的左上角的Y坐标 */
	private int posY;
	
	public Pilot(Position p, int i) {
		this.position = p;
		this.influence = i;
	}
	
	
	//getter and setter
	public int getInfluence() {
		return influence;
	}


	public void setInfluence(int influence) {
		this.influence = influence;
	}

	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
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
			//return this.pos_list.length;
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
