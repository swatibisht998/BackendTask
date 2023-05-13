package com.backendProject.Java.entities;

public class GenreMovie {

	private String genres;
    private String primaryTitle;
    private Integer numVotes;
    
	public GenreMovie() {
		super();
		
	}
	public GenreMovie(String genres, String primaryTitle, Integer numVotes) {
		super();
		this.genres = genres;
		this.primaryTitle = primaryTitle;
		this.numVotes = numVotes;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public Integer getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}
    
}
