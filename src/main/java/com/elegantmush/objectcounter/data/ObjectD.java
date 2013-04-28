package com.elegantmush.objectcounter.data;

public class ObjectD {

	private String s;
	private int i;

	public ObjectD() {
		this("", 0);
	}

	public ObjectD(String s) {
		this(s, 0);
	}

	public ObjectD(String s, int i) {
		this.s = s;
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public int getI() {
		return i;
	}

}
