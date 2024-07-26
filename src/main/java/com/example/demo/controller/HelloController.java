package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("hello") //ゲットメソッドと一緒 @PostMappingならPostと一緒になる。
	
	public String greeting() {
		return "index.html";//呼び出されるとindex.htmlを返す。
	}

}
