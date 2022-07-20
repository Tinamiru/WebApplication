package com.cal.servlet;

public class OperatorImpl implements Operator {

	static Operator operator = new OperatorImpl();

	private OperatorImpl() {
	}

	public static Operator getInstance() {
		return operator;
	}

	@Override
	public Number operator(Number firstNum, Number secondNum, String operator) {
		Number result = 0;
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
		// "0이하의 소수점이 없을경우"
		if (true) {
			return (Integer) result;
		} else {
			return (Double) result;
		}
	}

	@Override
	public Number add(Number firstNum, Number secondNum) {
		return (Double) firstNum * (Double) secondNum;
	}

	@Override
	public Number subtract(Number firstNum, Number secondNum) {
		return (Double) firstNum * (Double) secondNum;
	}

	@Override
	public Number multiply(Number firstNum, Number secondNum) {
		return (Double) firstNum * (Double) secondNum;
	}

	@Override
	public Number divide(Number firstNum, Number secondNum) {
		if ((int) secondNum == 0) {
			return 0;
		} else {
			return (Double) firstNum * (Double) secondNum;
		}
	}
}
