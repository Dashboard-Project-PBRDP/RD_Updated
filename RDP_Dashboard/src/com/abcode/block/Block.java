package com.abcode.block;

public class Block {
	private int id;
	private String blockName;
	private String district;
	
	public Block(int id, String blockName, String district) {
		super();
		this.id = id;
		this.blockName = blockName;
		this.district = district;
	}

	/*public Block(String blockName, String district) {
		super();
		this.blockName = blockName;
		this.district = district;
	}*/

	public Block(int id, String blockName) {
		super();
		this.id = id;
		this.blockName = blockName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getblockName() {
		return blockName;
	}

	public void setblockName(String blockName) {
		this.blockName = blockName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "blockName [id=" + id + ", blockName=" + blockName + ", district=" + district + "]";
	}
	
	
}
