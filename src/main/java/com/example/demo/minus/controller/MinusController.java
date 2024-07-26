package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	public MinusController(MinusService minusServise) {
		this.minusService = minusServise;
	}

	@GetMapping("minus")
	public String showSignUpForm() {
		return "minus.html";
	}

	@PostMapping("minusCal")
	public String minus(@RequestParam("leftNum") int leftNum, @RequestParam("rightNum") int rightNum, Model model) {

		int result;
		result = minusService.minusCalculation(leftNum, rightNum);
		model.addAttribute("result", result);

		return "minus.html";
	}
}
