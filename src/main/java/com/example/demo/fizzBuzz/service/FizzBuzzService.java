package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	/**
	 * 3、5、3と5 それぞれの倍数に応じて文字列と数値を格納する
	 * @return fizubuzzList
	 */
	public List<String> fizzBuzz() {
		//Listの宣言
		List<String> fizzbuzzList = new ArrayList<String>();
		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				fizzbuzzList.add("FizzBuzz");
			} else if (i % 5 == 0) {
				fizzbuzzList.add("Buzz");
			} else if (i % 3 == 0) {
				fizzbuzzList.add("Fizz");
			} else {
				fizzbuzzList.add(String.valueOf(i));
			}
		}
		return fizzbuzzList;
	}
}
