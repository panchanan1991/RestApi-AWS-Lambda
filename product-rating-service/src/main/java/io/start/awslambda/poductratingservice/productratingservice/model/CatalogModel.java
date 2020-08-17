package io.start.awslambda.poductratingservice.productratingservice.model;

/**
 * @author Panchanan
 *
 */
public class CatalogModel {

	private String MovieId;
	private String MovieDetails;
	private String MovieName;
	private String MovieOverview; 
	private String MovieRelease_date;
	private String error;
	private String MovieRating;
	private String countOfVoters;
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public String getMovieDetails() {
		return MovieDetails;
	}
	public void setMovieDetails(String movieDetails) {
		MovieDetails = movieDetails;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getMovieOverview() {
		return MovieOverview;
	}
	public void setMovieOverview(String movieOverview) {
		MovieOverview = movieOverview;
	}
	public String getMovieRelease_date() {
		return MovieRelease_date;
	}
	public void setMovieRelease_date(String movieRelease_date) {
		MovieRelease_date = movieRelease_date;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMovieRating() {
		return MovieRating;
	}
	public void setMovieRating(String movieRating) {
		MovieRating = movieRating;
	}
	public String getCountOfVoters() {
		return countOfVoters;
	}
	public void setCountOfVoters(String countOfVoters) {
		this.countOfVoters = countOfVoters;
	}
		
}
