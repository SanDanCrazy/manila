package manila.model;


public interface GetOnPosition {
	/**
	 * 当一个玩家分配海员登上该船时，调用该函数用以更新船上位置的信息
	 * @param pid 登船玩家的ID
	 */
	public void getOnboard(int pid);
	
	/**
	 * 获得该船当前空着的位置的编号（登船时自动从较低的编号开始）
	 * @return 当前编号最小的空位所对应的编号值
	 */
	public int getAvailPosIndex();
	
	/**
	 * 返回当前船上已有多少个坐了人的位置数
	 * @return 已有人的位置数
	 */
	public int getFilledPosNum();
	
	/**
	 * 返回当前编号最小的空位对应的登船费用
	 * 海盗登船不需要付费
	 * @return 当前编号最小的空位对应的登船费用
	 */
	public int getAvailPosPrice();
	
	
}
