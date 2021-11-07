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
	public FavoriteService(FavoriteRepo favoriterepo, AES256 ae) {

		super();
		this.favoriterepo = favoriterepo;

	}

	public List<Favorite> findAll() { return favoriterepo.findAll(); }

	public Favorite findById(int ID) {
		Optional<Favorite> favoriteOpt = favoriterepo.findById(ID);
		Favorite favoriteID = favoriteOpt.get();
		return favoriteID;

	}

	@Modifying
	@Transactional
	// VV Use Save For Save And Update
	public void addOrUpdateFavorite(Favorite favorite) { favoriterepo.save(favorite); }

	@Transactional
	public void deleteFavorite(int ID) {
		Favorite favorite = findById(ID);
		favoriterepo.delete(favorite);
	}

}
