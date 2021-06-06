package com.noble.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noble.app.service.SearchByYear;
import com.noble.app.service.SearchDetails;

@RestController
@RequestMapping("/users")
public class SearchController {

	String retrievedname;

	@Autowired
	SearchDetails searchDetails;

	@Autowired
	SearchByYear searchByYear;

	@GetMapping("/prizes/{name}")
	public String getUserDetails(@PathVariable("name") String name) {

		retrievedname = searchDetails.getDetails(name);

		if (retrievedname.equals(name)) {
			return name;
		} else
			return "No Matching person found in Prizes list";

	}

	@GetMapping("/prizes/{year}")
	public Map<String, String> getUserListDetails(@PathVariable("year") String year) {

		return searchByYear.getDetails(year);

	}

}
