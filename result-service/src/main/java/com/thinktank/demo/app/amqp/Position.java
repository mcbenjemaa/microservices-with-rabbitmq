package com.thinktank.demo.app.amqp;

public class Position {
	
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
	
	
	

}
