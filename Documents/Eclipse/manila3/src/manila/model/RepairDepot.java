package manila.model;

/**
 * 修理港类，若有到达修理港的小船就可获利 
 * @author SanDan
 */
public class RepairDepot implements GetOnPosition{
	
	private Position position;
	
	private String name;
	
	private int repair_value;
	
	private boolean fulled;
	
	private int posX;
	private int posY;
	
	public RepairDepot(Position p, String n, int v) {
		this.setPosition(p);
		this.name = n;
		this.setRepair_value(v);
		this.setFulled(false);
	}

	
	
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

	@Override
	public void getOnboard(int pid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAvailPosIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFilledPosNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAvailPosPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCursorInside(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
