package com.example.demo.multi.service;

import org.springframework.stereotype.Service;

@Service
public class MultiService {
	/**
	 * 
	 * @param num1 引数1
	 * @param num2 引数2
	 * @return 掛け算結果
	 */
	public int Multiplication(int num1, int num2) {

		int result;

		result = num1 * num2;

		return result;
	}
}
