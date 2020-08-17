package io.start.awslambda.poductratingservice.productratingservice.model;

/**
 * @author Panchanan
 * This is pojo class which contains productId, Product Details, ProductName
 */
public class ProductDetailsModel {
	
	private String productId;
	private String productDetails;
	private String name;
	private String overview; 
	private String release_date;
	
	public ProductDetailsModel() {
		super();
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



	public ProductDetailsModel(String productId, String productDetails, String name) {
		super();
		this.productId = productId;
		this.productDetails = productDetails;
		this.name = name;
	}


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
	
	

}
