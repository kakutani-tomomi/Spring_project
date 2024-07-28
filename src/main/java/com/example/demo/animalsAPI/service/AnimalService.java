package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {
	private final AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
	/**
	 * 動物の一覧を取得する。
	 * @return animalList 
	 * @throws IOException
	 */
	public List<AnimalData> getAnimalList() throws IOException {

		AnimalData[] animalsList = animalRepository.getAnimalList();

		return Arrays.asList(animalsList);

	}
	/**
	 * APIから指定された動物を取得する
	 * @param id 指定された動物のid
	 * @return 対象の動物
	 * @throws IOException
	 */
	public AnimalData[] getAnimal(String id) throws IOException {
		
		AnimalData animal[] = animalRepository.getAnimal(id);

		return animal;

	}
}

