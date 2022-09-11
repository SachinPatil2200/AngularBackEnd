package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Country;

public interface CountryDao {
	public Country saveCountry(Country Country);

	public Country getCountryById(int CountryId);

	public List<Country> getAllCountry();

	public boolean deleteCountryById(int CountryId);

	public Country updatCountry(Country Country);
}
