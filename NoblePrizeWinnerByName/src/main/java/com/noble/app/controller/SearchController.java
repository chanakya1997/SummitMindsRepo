package com.noble.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noble.app.service.SearchByYear;
import com.noble.app.service.SearchDetails;


/**
 * The Class SearchController.
 */
@RestController
@RequestMapping("/users")
public class SearchController {

	/** The retrievedname. */
	String retrievedname;

	/** The search details. */
	@Autowired
	SearchDetails searchDetails;

	/** The search by year. */
	@Autowired
	SearchByYear searchByYear;

	/**
	 * Gets the user details.
	 *
	 * @param name the name
	 * @return the user details
	 */
	@GetMapping("/prizes/{name}")
	public String getUserDetails(@PathVariable("name") String name) {

		retrievedname = searchDetails.getDetails(name);

		if (retrievedname.equals(name)) {
			return name;
		} else
			return "No Matching person found in Prizes list";

	}

	/**
	 * Gets the user list details.
	 *
	 * @param year the year
	 * @return the user list details
	 */
	@GetMapping("/prizes/{year}")
	public Map<String, String> getUserListDetails(@PathVariable("year") String year) {

		return searchByYear.getDetails(year);

	}

}
