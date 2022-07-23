package com.cal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.service.AlertFlagSetup;
import com.cal.service.AlertFlagSetupImpl;
import com.cal.service.Operator;
import com.cal.service.OperatorImpl;
import com.cal.service.ProcessedAndCutDecimal;
import com.cal.service.ProcessedAndCutDecimalImpl;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/calculator.jsp";

		request.setAttribute("result", "");
		request.setAttribute("formula", "");
		request.setAttribute("operator", "");
		request.setAttribute("secondOpper", "");
		request.setAttribute("alertFlag", "false");

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/calculator.jsp";

		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		String operator = request.getParameter("operator");
		double secondNum = Double.parseDouble(request.getParameter("secondNum"));
		String secondOpper = request.getParameter("secondOpper");

		ProcessedAndCutDecimal processedAndCutDecimalImpl = ProcessedAndCutDecimalImpl.getInstance();
		Operator operatorImpl = OperatorImpl.getInstance();
		AlertFlagSetup alertFlagSetupImpl = AlertFlagSetupImpl.getInstance();

		Number result = operatorImpl.operator(firstNum, secondNum, operator);
		Number firstNumForformula = processedAndCutDecimalImpl.processed(firstNum);
		Number secondNumForformula = processedAndCutDecimalImpl.processed(secondNum);

		String formula = firstNumForformula + " " + operator + " " + secondNumForformula + " = " + result + " "
				+ secondOpper;
		boolean alertFlag = alertFlagSetupImpl.alertFlagResult();

		request.setAttribute("result", result);
		request.setAttribute("operator", secondOpper);
		request.setAttribute("secondOpper", secondOpper);
		request.setAttribute("formula", formula);
		request.setAttribute("alertFlag", alertFlag);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
