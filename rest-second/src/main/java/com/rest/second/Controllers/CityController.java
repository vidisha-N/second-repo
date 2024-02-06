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
import com.rest.second.model.City;
import com.rest.second.repo.CityRepo;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityRepo cityRepo;

	@GetMapping("/")
	public ResponseEntity<List<CityTo>> getAllCityDetails() {

		List<City> findAll = cityRepo.findAll();

		CityTo ctto = null;

		List<CityTo> tolist = new ArrayList<CityTo>();

		for (City c : findAll) {
			ctto = new CityTo();
			ctto.setId(c.getId());
			ctto.setName(c.getName());

			ctto.setDistrict(c.getDistrict());
			ctto.setPopulation(c.getPopulation());

			tolist.add(ctto);
		}

		return new ResponseEntity<List<CityTo>>(tolist, HttpStatus.OK);
	}
}
