package manila.model;

import manila.view.PlaygroundView;

/**
 * 海盗类，可以对小船进行占位和掠夺
 * @author SanDan
 */
public class Pirate implements GetOnPosition{
	/** 空位数组 */
	private Position[] pos_list;
	
	
	
	private int posX;
	private int posY;
	
	public Pirate(Position[] p) {
		this.pos_list = p;
	}
	
	/**
	 * 判断能否登上这艘船，登上船后相当于掠夺该船
	 * @param b 将要登的船
	 * @return 船还有空位就登船并且返回true,否则返回false
	 */
	public boolean pirateIsComing(Boat b) {
		if(b.getFilledPosNum() == b.getPos_list().length) return false;
		else {
			getOnboard(pos_list[0].getSailorID());
			attackBoat(b);
			return true;
		}
	}
	
	/**
	 * 掠夺船只,并且船员升为海盗船长
	 * @param b 要掠夺的船
	 */
	public void attackBoat(Boat b) {
		b.beAttackedByPirate(pos_list[0].getSailorID());
		pos_list[0].setSailorID(-1);
		changeCaptain();
	}
	
	/**
	 * 海盗船长登船后船员升为船长
	 */
	public void changeCaptain() {
		if(pos_list[1].getSailorID() == -1) ;
		else {
			pos_list[0].setSailorID(pos_list[1].getSailorID());
			pos_list[1].setSailorID(-1);
		}
	}
	
	public Position getCaptainPos() {
		return this.pos_list[0];
	}
	@Override
	public void getOnboard(int pid) {
		this.pos_list[getAvailPosIndex()].setSailorID(pid);
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
		return 0;
	}

	
}
