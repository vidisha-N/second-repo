package com.rest.second.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.second.To.CityTo;
import com.rest.second.To.CountryTo;
import com.rest.second.model.City;
import com.rest.second.model.Country;
import com.rest.second.repo.CityRepo;
import com.rest.second.repo.CountryRepo;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
 CountryRepo countryRepo;
	
	
	@GetMapping("/")
	public ResponseEntity<List<CountryTo>> getAllCountryDetails() {

		 List<Country> findAll = countryRepo.findAll();
		 

		 CountryTo to = null;

		
		 List<CountryTo> conlist =new ArrayList<CountryTo>();
		 
		 for(Country c : findAll)
		 {
			 to =new CountryTo();
			 to.setCode(c.getCode());
			 to.setName(c.getName());
			 to.setContinent(c.getContinent());
			 to.setIndepYear(c.getIndepYear());
			 to.setRegion(c.getRegion());
			 to.setSurfaceArea(c.getSurfaceArea());
			 to.setPopulation(c.getPopulation());
			  
			 conlist.add(to);
		 }
		 
		return new ResponseEntity<List<CountryTo>>(conlist, HttpStatus.OK);
	}
}
