package com.cal.servlet;

public interface Operator {

	public int operator(int firstNum, int secondNum, String operator);

	public int add(int firstNum, int secondNum);

	public int subtract(int firstNum, int secondNum);

	public int multiply(int firstNum, int secondNum);

	public int divide(int firstNum, int secondNum);
}
