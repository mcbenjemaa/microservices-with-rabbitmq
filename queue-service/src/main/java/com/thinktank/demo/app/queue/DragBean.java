package com.thinktank.demo.app.queue;

import java.io.Serializable;

public class DragBean  implements Serializable  {
	
	 private double left;
	 private double right;
	 
	public DragBean(double left, double right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	public double getRight() {
		return right;
	}
	public void setRight(double right) {
		this.right = right;
	}


	@Override
	public String toString() {
		return "DragBean [left=" + left + ", right=" + right + "]";
	}
	 
	
	
 
}
