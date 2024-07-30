package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {
	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("animalSearch")
	public String AnimalSearch(Model model) throws IOException {

		List<AnimalData> animalsList = animalService.getAnimalList();

		model.addAttribute("animalsList", animalsList);

		return "animal-search.html";

	}

	@GetMapping("animalDetail")
	public String AnimalData(@RequestParam("id") String id, Model model) throws IOException {

		AnimalData[] animalData = animalService.getAnimal(id);

		System.out.println(animalData.length);

		model.addAttribute("animalData", animalData);

		return "animal-detail.html";
	}
}
