package com.cg.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cg.sprint.dao.AdminDao;
import com.cg.sprint.dao.CityDao;


import com.cg.sprint.dao.MoviesDao;

import com.cg.sprint.dao.ShowsDao;
import com.cg.sprint.dao.TheatreDao;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;


import com.cg.sprint.entity.Movies;



import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.exceptions.IdNotFoundException;

@Service
@Transactional
public class AdminService implements AdminServiceInterface  {

		@Autowired
	private CityDao city;
	@Autowired
	private TheatreDao theatre;
	@Autowired
	private MoviesDao movie;
	@Autowired
	private ShowsDao shows;
	@Autowired
	private AdminDao admin;
	
	
	 

	//Login of an admin  
	@Override
	public Admin aLogin(String uname, String pass) {
		return admin.aLogin(uname, pass);
	}
	@Override
	public City save(City c)
    {
   	 return city.save(c);
    }
	@Override
	public Theatre save(Theatre t)
    {
   	 return theatre.save(t);
    }
	@Override
	public Movies save(Movies m)
    {
   	 return movie.save(m);
    }
	@Override
	public Shows save(Shows s)
    {
   	 return shows.save(s);
    }
	@Override
	public List<City> getCityList() {
		return city.getCityList();
	}
	@Override
	public List<Movies> getMovieList() {
		return movie.getMovieList();
	}
	@Override
	public List<Theatre> getTheatreList() {
		return theatre.getTheatreList();
	}
	@Override
	public List<Shows> getShowList() {
		return shows.getShowList();
	}
	
	
	@Override
	public String updateCity(City c) {
	if(city.existsById(c.getSno()))
				{
			city.save(c);
			return "cities were updated successfully!!";
				}
		else {
			return "sorry, cities were not updated";
			//return throw new IdNotFoundException;
		}
		
	}
	@Override
	public String updateTheatre(Theatre t) {
		if(theatre.existsById(t.getTheatreId())) {
			theatre.save(t);
			return "theatres were updated successfully!!";
		}
		else {
			return "theatres were not updated";
		}
	}
	@Override
	public String updateMovies(Movies m) {
		if(movie.existsById(m.getMovieId())) {
			movie.save(m);
			return "movies were updated successfully!!";
		}
		else {
			return "movies were not updated";
		}
	}
	@Override
	public String updateShows(Shows s) {
		if(shows.existsById(s.getSno())) {
			shows.save(s);
			return "shows were updated successfully!!";
		}
		else {
			return "shows were not updated";
		}
	}
    @Override
    public void removeCity(int sno)
    {
   	  city.deleteById(sno);
    }
    @Override
    public void removeTheatre(int theatreId)
    {
   	  theatre.deleteById(theatreId);
    }
    @Override
    public void removeMovie(int movieId)
    {
   	  movie.deleteById(movieId);
    }
    @Override
    public void removeShow(int sno)
    {
   	  shows.deleteById(sno);
    }
	
}