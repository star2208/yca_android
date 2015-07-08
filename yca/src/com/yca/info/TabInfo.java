package com.yca.info;

import java.io.Serializable;

public class TabInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int type;
	private int id;
	
	
	public TabInfo(int type, int id) {
		// TODO Auto-generated method stub
		this.type = type;
		this.id = id;

	}
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

}
