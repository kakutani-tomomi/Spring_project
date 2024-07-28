package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public int calculation(int leftNum, int rightNum, String operator) throws ArithmeticException {
		int result = 0;
		//加算
		if ("＋".equals(operator)) {
			result = leftNum + rightNum;
			//減算	
		} else if ("－".equals(operator)) {
			result = leftNum - rightNum;
			//除算
		} else if ("×".equals(operator)) {
			result = leftNum * rightNum;
			//剰余算	
		} else if ("÷".equals(operator)) {
			result = leftNum / rightNum;
		}
		return result;
	}
}
