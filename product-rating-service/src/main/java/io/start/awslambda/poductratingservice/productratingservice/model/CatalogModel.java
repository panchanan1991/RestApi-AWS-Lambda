package io.start.awslambda.poductratingservice.productratingservice.model;

/**
 * @author Panchanan
 *
 */
public class CatalogModel {

	private String productId;
	private String productDetails;
	private String name;
	private String overview; 
	private String release_date;
	private String error;
	private String rating;
	private String countOfVoters;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCountOfVoters() {
		return countOfVoters;
	}
	public void setCountOfVoters(String countOfVoters) {
		this.countOfVoters = countOfVoters;
	}
	
	
	
}
