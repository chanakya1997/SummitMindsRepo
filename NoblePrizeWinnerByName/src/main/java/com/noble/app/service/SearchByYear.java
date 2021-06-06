package com.noble.app.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SearchByYear {

	static String firstname;
	public static Map<String, String> maa = new HashMap<>();

	public Map<String, String> getDetails(String yr) {

		JSONParser jsonParser = new JSONParser();
		Object object;

		try {

			/*
			 * ObjectMapper mapper = new ObjectMapper(); TypeReference<List<User>>
			 * typeReference = new TypeReference<List<User>>(){}; InputStream inputStream =
			 * TypeReference.class.getResourceAsStream("/json/Awards.json"); try {
			 * List<User> users = mapper.readValue(inputStream,typeReference);
			 * userService.save(users); System.out.println("Users Saved!"); } catch
			 * (IOException e){ System.out.println("Unable to save users: " +
			 * e.getMessage()); } }
			 */

			object = jsonParser.parse(new FileReader("//Users//chaitanyabalaka//downloads//nessted.json"));

			JSONObject jsonObject10 = (JSONObject) object;

			JSONArray prizes = (JSONArray) jsonObject10.get("prizes");

			Iterator itr = prizes.iterator();

			while (itr.hasNext()) {

				Object slide = itr.next();
				JSONObject jsonObject2 = (JSONObject) slide;

				// System.out.println("\n \n");

				String year = (String) jsonObject2.get("year");

				if (yr.equals(year)) {

					// System.out.println("\t\tYear : " + year);
					String category = (String) jsonObject2.get("category");

					// System.out.println("\t\tCategory : " + category);

					JSONArray soundex = (JSONArray) jsonObject2.get("laureates");

					Iterator itr1 = soundex.iterator();

					while (itr1.hasNext()) {

						Object slide1 = itr1.next();
						JSONObject jsonObject21 = (JSONObject) slide1;

						firstname = (String) jsonObject21.get("firstname");
						String surname = (String) jsonObject21.get("surname");

						maa.put("Year", year);
						maa.put("firstname", firstname);
						maa.put("surname", surname);

						return maa;

					}
				} else {

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return maa;

	}

}
