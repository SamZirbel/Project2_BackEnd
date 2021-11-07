package com.revature.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int movieId;
    
    private String title;
    
    private String genre;
    
    private String director;
    
    private String synopsis;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date release;

	public Movie(int movieId, String title, String genre, String director, String synopsis, Date release) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.synopsis = synopsis;
		this.release = release;
	}

	public Movie(String title, String genre, String director, String synopsis, Date release) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.synopsis = synopsis;
		this.release = release;
	}

	public Movie() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (movieId != other.movieId)
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", director=" + director
				+ ", synopsis=" + synopsis + ", release=" + release + "]";
	}

    
    
}