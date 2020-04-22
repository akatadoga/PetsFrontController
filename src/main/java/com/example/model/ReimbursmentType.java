package com.example.model;

public class ReimbursmentType {
	
	
	int typeId;
	String type;
	
	public ReimbursmentType() {
		super();
	}
	
	public ReimbursmentType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	 
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ReimbursmentType [typeId=" + typeId + ", type=" + type + "]";
	}
	
}
