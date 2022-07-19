package com.cal.servlet;

public class OperatorImpl implements Operator {

	static Operator operator = new OperatorImpl();

	private OperatorImpl() {
	}

	public static Operator getInstance() {
		return operator;
	}

	@Override
	public int operator(int firstNum, int secondNum, String operator) {
		int result = 0;
		switch (operator) {
		case "+":
			result = add(firstNum, secondNum);
			break;
		case "-":
			result = subtract(firstNum, secondNum);
			break;
		case "*":
			result = multiply(firstNum, secondNum);
			break;
		case "/":
			result = divide(firstNum, secondNum);
			break;
		}
		return result;
	}

	@Override
	public int add(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

	@Override
	public int subtract(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}

	@Override
	public int multiply(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

	@Override
	public int divide(int firstNum, int secondNum) {
		return firstNum / secondNum;
	}
}
