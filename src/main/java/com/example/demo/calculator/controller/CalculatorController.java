package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {	
	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	@GetMapping("calculator")
	public String calulator() {
		return "calculator.html";
	}
	
	@PostMapping("calcResult")
	public String numPlus(@RequestParam("leftNum") int leftNum,
			@RequestParam("rightNum")int rightNum,@RequestParam("operator")String operator,
			Model model) {
			try {
			int result = calculatorService.calculation(leftNum, rightNum, operator);
			System.out.println(result);
			model.addAttribute("result",result);
			}catch (ArithmeticException e) {
				String errorMassage = "0除算は出来ません。";
				model.addAttribute("errorMessage", errorMassage);
			}
		return "calculator.html";
	}
	
	
	
}


