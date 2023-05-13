package com.backendProject.Java.entities;

public class Movie {

	private String tconst;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;
    private String titleType;
    
	public Movie() {
		super();
		
	}
	public Movie(String tconst, String primaryTitle, Integer runtimeMinutes, String genres, String titleType) {
		super();
		this.tconst = tconst;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
		this.titleType = titleType;
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
	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}
	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
    
	
    
}
