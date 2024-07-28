package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {
	public int minusCalculation(int leftNum, int rightNum) {

		int result;
		result = (leftNum - rightNum);
		return result;
	}
}
