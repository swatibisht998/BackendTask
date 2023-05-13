package com.backendProject.Java.entities;

public class MovieRating {

	private String tconst;
    private String primaryTitle;
    private String genres;
    private Float averageRating;
    
    
	public MovieRating() {
		super();
		
	}
	public MovieRating(String tconst, String primaryTitle, String genres, Float averageRating) {
		super();
		this.tconst = tconst;
		this.primaryTitle = primaryTitle;
		this.genres = genres;
		this.averageRating = averageRating;
	}
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public Float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}
    
    
}
