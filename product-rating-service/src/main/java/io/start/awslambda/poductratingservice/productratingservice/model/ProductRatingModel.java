package io.start.awslambda.poductratingservice.productratingservice.model;

/**
 * This class is pojo class
 * @author Panchanan
 *
 */
public class ProductRatingModel {
	
	
	private String productId;
	private String rating;
	private String countOfVoters;
	
	
	public ProductRatingModel() {
		super();
	}
	
	
	public String getCountOfVoters() {
		return countOfVoters;
	}

	public void setCountOfVoters(String countOfVoters) {
		this.countOfVoters = countOfVoters;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
