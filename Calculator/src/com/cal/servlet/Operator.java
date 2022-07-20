package com.cal.servlet;

public interface Operator {

	public Number operator(Number firstNum, Number secondNum, String operator);

	public Number add(Number firstNum, Number secondNum);

	public Number subtract(Number firstNum, Number secondNum);

	public Number multiply(Number firstNum, Number secondNum);

	public Number divide(Number firstNum, Number secondNum);
}
