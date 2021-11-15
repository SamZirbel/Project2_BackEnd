package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.revature.models.Favorite;
import com.revature.repos.FavoriteRepo;

@Service
public class FavoriteService {
	
	private FavoriteRepo favoriterepo;

	@Autowired
	public FavoriteService(FavoriteRepo favoriterepo) {

		super();
		this.favoriterepo = favoriterepo;

	}

	public List<Favorite> findAll() { 
		return favoriterepo.findAll(); 
	}
	
	

	public Favorite findById(int ID) {
		return favoriterepo.findById(ID).get();
	}
	
	public List<Favorite> findByUser_userId(int id) {
		Optional<List<Favorite>> oList = favoriterepo.findByUser_userId(id);
		if (oList.isPresent()) {
			List<Favorite> list = oList.get();
			if (list.size() == 0) {
				throw new IllegalArgumentException("No Favorites!");
			}
			return list;
		}
		return new ArrayList<Favorite>();
	}
	
	public List<Favorite> findByMovie_movieId(int id) {
		Optional<List<Favorite>> oList = favoriterepo.findByMovie_movieId(id);
		if (oList.isPresent()) {
			List<Favorite> list = oList.get();
			if (list.size() == 0) {
				throw new IllegalArgumentException("No Favorites!");
			}
			return list;
		}
		return new ArrayList<Favorite>();
	}

	@Modifying
	@Transactional
	// VV Use Save For Save And Update
	public void addOrUpdateFavorite(Favorite favorite) {
		favoriterepo.save(favorite); 
	}

	@Transactional
	public void deleteFavorite(int ID) {
		Favorite favorite = findById(ID);
		favoriterepo.delete(favorite);
	}

}
