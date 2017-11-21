package manila.model;

public enum Cargo {

	GINSENG("人参", 1, 0), SILK("丝绸", 2, 0), NUTMEG("肉豆蔻", 3, 0), JADE("玉", 4, 0);
	
	private String name;
	private int index;
	private int value;
	
	private Cargo(String n, int i, int v) {
		this.setName(n);
		this.setIndex(i);
		this.setValue(v);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void valueRaise() {
		this.value += 5;
	}
	
}
