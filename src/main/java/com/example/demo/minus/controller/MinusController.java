package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	//serviceクラスのメソッドを利用するために、フィールドを定義。
	private final MinusService minusService;
	//serviceクラスのメソッドを利用するために、コンストラクタを使用して、フィールドにインスタンス情報を格納
	public MinusController(MinusService minusServise) {
		this.minusService = minusServise;
	}

	@GetMapping("minus")
	public String showMinus() {
		return "minus.html";
	}

	@PostMapping("minusResult")
	public String minus(@RequestParam("leftNum") int leftNum, @RequestParam("rightNum") int rightNum, Model model) {
		System.out.println(leftNum);
		System.out.println(rightNum);
		int result;
		result = minusService.minusCalculation(leftNum, rightNum);
		model.addAttribute("result", result);
		return "minus.html";
	}
}
