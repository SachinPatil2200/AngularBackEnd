package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CountryDao;
import com.jbk.entity.Country;
@Service
public class CountryService_Impl implements CountryService {
@Autowired
private CountryDao dao;
	@Override
	public Country saveCountry(Country country) {
		Country countryy=dao.saveCountry(country);
		return countryy;
	}

	@Override
	public Country getCountryById(int CountryId) {
		Country country=dao.getCountryById(CountryId);
		return country;
	}

	@Override
	public List<Country> getAllCountry() {
		List <Country> list=dao.getAllCountry();
		return list;
	}

	@Override
	public boolean deleteCountryById(int CountryId) {
		boolean bl=dao.deleteCountryById(CountryId);
		return bl;
	}

	@Override
	public Country updatCountry(Country Country) {
		Country country=dao.updatCountry(Country);
		return country;
	}

}
