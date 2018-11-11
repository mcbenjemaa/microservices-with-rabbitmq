package com.thinktank.demo.app.queue;

import java.io.Serializable;

public class Position implements Serializable {
	
	private String left;
	private String top;
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public Position(String left, String top) {
		super();
		this.left = left;
		this.top = top;
	}
	public Position() {
		super();
	}
	@Override
	public String toString() {
		return "Position [left=" + left + ", top=" + top + "]";
	}
	
	
	
	

}
