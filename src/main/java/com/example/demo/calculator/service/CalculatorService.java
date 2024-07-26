package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public int calculation (int leftNum,int rightNum,String operator) throws ArithmeticException{
		int result = 0;
		if("＋".equals(operator)) {
			result = leftNum + rightNum;
		}else if("－".equals(operator)) {
			result = leftNum - rightNum;
		}else if("×".equals(operator)) {
			result = leftNum * rightNum;
		}else if("÷".equals(operator)) {
			result = leftNum / rightNum;
		}
		return result;
		}
	}
