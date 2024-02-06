package com.rest.second.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.second.model.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
