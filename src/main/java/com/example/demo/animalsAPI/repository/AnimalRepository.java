package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {

	public AnimalData[] getAnimalList() throws IOException {
		//動物情報一覧APIのｐＵＲＬ
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";

		//Rest通信(Api呼び出し)にかかわるメソッド利用の為にnew
		RestTemplate rest = new RestTemplate();
		/*
		 * getForEntity.....URLとレスポンスボディを引数に渡して、ResponseEntityオブジェクト(中身)を取得するメソッド
		 * url....APIのURL
		 * String.class....レスポンスボディのタイプ指定。今回はString(文字列)で受け取る。右の.classで指定した型で戻り値が帰ってくる？
		 */
		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		//取得したエンティティをJSON文字列に変換
		String json = response.getBody();

		//mapperクラスの利用の為new
		ObjectMapper mapper = new ObjectMapper();

		//JSON文字列をデシリアライズして配列に格納. バイナリ→オブジェクトに戻す感じ？
		//Jsonは配列で受け取らないとエラーでる(出た)、
		AnimalData[] animalsList = mapper.readValue(json, AnimalData[].class);

		return animalsList;
	}

	public AnimalData[] getAnimal(String id) throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id=" + id;

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AnimalData[] animalData = mapper.readValue(json, AnimalData[].class);

		return animalData;
	}
}
