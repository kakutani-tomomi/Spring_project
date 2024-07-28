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
	public String showCalc() {
		return "calculator.html";
	}

	@PostMapping("calcResult")
	public String calculator(@RequestParam("leftNum") int leftNum, @RequestParam("rightNum") int rightNum,
			@RequestParam("operator") String operator, Model model) {
		try {
			int result;
			result = calculatorService.calculation(leftNum, rightNum, operator);//①左辺②右辺③算術演算子
			model.addAttribute("result", result);

		} catch (ArithmeticException e) {
			String errorMessage = "ゼロ除算はできません";
			model.addAttribute("errorMessage", errorMessage);
		}

		return "calculator.html";
	}
}
