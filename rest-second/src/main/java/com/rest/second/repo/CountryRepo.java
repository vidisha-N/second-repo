package com.rest.second.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.second.model.Country;

public interface CountryRepo extends JpaRepository<Country, String> {

}
