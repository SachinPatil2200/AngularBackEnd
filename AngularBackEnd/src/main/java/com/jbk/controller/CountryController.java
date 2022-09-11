package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Country;

import com.jbk.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	private CountryService service;
			
	@PostMapping("/saveCountry")
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
	Country countryy=	service.saveCountry(country);
	if(countryy!=null) {
		return new ResponseEntity<>(countryy,HttpStatus.CREATED);
	}
	else
		
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@GetMapping(value="/getCountryById/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable int id) {
	Country emp=service.getCountryById(id);
	if(emp!=null) {
	return new	ResponseEntity<Country>(emp,HttpStatus.FOUND);
	}
	else 
		return new ResponseEntity<Country>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	@GetMapping(value="/getAllCountry")
	public ResponseEntity<List<Country>> getAllCountry(){
		
	List<Country> list=	service.getAllCountry();
	if(list!=null) {
		return new ResponseEntity<List<Country>>(list,HttpStatus.FOUND);
	}
	else 
		return new  ResponseEntity<List<Country>>(HttpStatus.INTERNAL_SERVER_ERROR);
				
		
	}

	@DeleteMapping(value="/deleteCountryById/{eid}") 
	public ResponseEntity<String> deleteCountryById(@PathVariable int eid){
		boolean bl=service.deleteCountryById(eid);
		if(bl) {
			return new ResponseEntity<String>("Successfully Deleted...!",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Something Went To Wrong...!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country emp) {
		System.out.println(emp);

		Country Country = service.saveCountry(emp);

		if (Country != null) {
			return new ResponseEntity<Country>(Country, HttpStatus.CREATED);

		}

		return new ResponseEntity<Country>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
