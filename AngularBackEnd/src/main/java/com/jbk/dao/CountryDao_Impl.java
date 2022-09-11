package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Country;
import com.jbk.entity.Country;

@Repository
public class CountryDao_Impl implements CountryDao {
@Autowired
private SessionFactory factory;
	@Override
	public Country saveCountry(Country country) {
		Session s=factory.openSession();
	Transaction tt=	s.beginTransaction();
	                try {
						s.save(country);
						tt.commit();
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}finally {
						s.close();
					}
		         return country;
	}

	@Override
	public Country getCountryById(int CountryId) {
		
		Session s=factory.openSession();
		Country country;
	try {
		country=s.get(Country.class,CountryId );
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		s.close();
		}
		return country;
	}

	@Override
	public List<Country> getAllCountry() {
		Session s=	factory.openSession();
		List<Country> list;
		try {
			Criteria crt=s.createCriteria(Country.class);
			list=crt.list();
		}	
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				s.close();
			}
				return list;
	}

	@Override
	public boolean deleteCountryById(int CountryId) {
		Session s=  factory.openSession();
		Transaction tt=	s.beginTransaction();
		try {
			Country country=s.get(Country.class,CountryId );
			System.out.println(country);
			s.remove(country);
			tt.commit();
		} catch (Exception e) {
			return false;
		}finally {
			s.clear();
		}
		return true;
	}

	@Override
	public Country updatCountry(Country country) {
		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();
		try {
			s.update(country);
			tt.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			s.close();
		}
		return country;
	}


	



	
}
