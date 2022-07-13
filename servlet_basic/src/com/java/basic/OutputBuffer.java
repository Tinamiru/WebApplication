package com.java.basic;

public class OutputBuffer {
	private String buffer = new String();
	private static OutputBuffer instance = new OutputBuffer();

	private OutputBuffer() {

	}

	public static OutputBuffer getInstance() {
		return instance;
	}

	public void out(String str) {
		this.buffer += str;
	}

	public void flush() {
		System.out.println(this.buffer);
		this.buffer = "";
	}
}