package com.yca.info;

import java.io.Serializable;

public class TabInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int type;
	private int id;
	private String title;
	
	
	public TabInfo(int type, int id, String title) {
		// TODO Auto-generated method stub
		this.type = type;
		this.id = id;
		this.title = title;

	}
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
}
