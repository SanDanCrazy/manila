package manila.model;

import manila.view.PlaygroundView;

/**
 * 保险员类，有固定收益，负责理赔
 * @author SanDan
 * BOAT_W以及BOAT_H未更改
 */
public class InsuranceOfficer implements GetOnPosition{
	/** 保险员空位 */
	private Position position;
	/** 选择保险员获得的补贴 */
	public static final int WELFARE = 10;
	
	/** 保险员（左上角）在图形界面上的X坐标 */
	private int posX;
	/** 保险员（左上角）在图形界面上的Y坐标 */
	private int posY;
	
	
	public InsuranceOfficer(Position p) {
		this.position = p;
	}
	
	
	public Position getPos() {
		return this.position;
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
