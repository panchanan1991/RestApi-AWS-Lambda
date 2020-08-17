package io.start.awslambda.poductratingservice.productratingservice.business;

import org.springframework.stereotype.Component;

import io.start.awslambda.poductratingservice.productratingservice.model.CatalogModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductDetailsModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductDetailsModelTO;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingsModelTO;

/**
 * This class is business class of the product rating service
 * @author Panchanan mal
 *
 */
@Component
public class ProductRatingBusiness {

	//Logger Log = LoggerFactory.getLogger(ProductRatingBusiness.class);
	/**
	 * This method is a business method where the business logic will be written
	 * @param id
	 * @return ProductRatingModel
	 */
	public ProductRatingModel getProductRating(ProductRatingsModelTO productRatingsModelTO) {
		//Log.debug("Inside class ProductRatingBusiness method getProductRating");
		return getProduct(productRatingsModelTO);
	}

	/**
	 * This method will do the business operation
	 * @param productRatingsModelTO
	 * @return ProductRatingModel
	 */
	public ProductRatingModel getProduct(ProductRatingsModelTO productRatingsModelTO) {

		System.out.println("Inside class ProductRatingBusiness method getProduct");

		ProductRatingModel  productRatingModel = new ProductRatingModel();
		if(null!=productRatingsModelTO && null!=productRatingsModelTO.getId()) {

			System.out.println("Product ID :: "+productRatingsModelTO.getId());
			productRatingModel.setProductId(productRatingsModelTO.getId());
			if(null!=productRatingsModelTO.getVote_average()) {
				System.out.println("The value of getVote_averge :: "+productRatingsModelTO.getVote_average());
				productRatingModel.setRating(productRatingsModelTO.getVote_average());
			}
			if(null!=productRatingsModelTO.getVote_count()) {
				System.out.println("The value of number of votes are :: "+productRatingsModelTO.getVote_count());
				productRatingModel.setCountOfVoters(productRatingsModelTO.getVote_count());
			}
			System.out.println("Returning the Product rating object with values");
			return productRatingModel;
		}else {
			System.out.println("Returning the Product rating object");
			return productRatingModel;
		}

	}

	/**
	 * @param productDetailsModelTO
	 * @return
	 */
	public ProductDetailsModel getProduct2(ProductDetailsModelTO productDetailsModelTO) {

		System.out.println("Inside  method getProduct");
		ProductDetailsModel productDetailsModel = new ProductDetailsModel();

		if(null!=productDetailsModelTO && null!=productDetailsModelTO.getId()) {
			System.out.println("Poduct id : "+productDetailsModelTO.getId());
			productDetailsModel.setProductId(productDetailsModelTO.getId());
			if(null!=productDetailsModelTO.getOverview()) {
				System.out.println("Product Overview :: "+productDetailsModelTO.getOverview());
				productDetailsModel.setProductDetails(productDetailsModelTO.getOverview());
			}
			if(null!=productDetailsModelTO.getOriginal_title()) {
				System.out.println("Poduct Original Title :: "+productDetailsModelTO.getOriginal_title());
				productDetailsModel.setName(productDetailsModelTO.getOriginal_title());
			}
			if(null!=productDetailsModelTO.getRelease_date()) {
				System.out.println("Product release date :: "+productDetailsModelTO.getRelease_date());
				productDetailsModel.setRelease_date(productDetailsModelTO.getRelease_date());
			}
			System.out.println("returning the object with values");

			return productDetailsModel;
		}else {
			System.out.println("returning the object without values");

			return productDetailsModel;
		}

	}
	
	public CatalogModel getPoductNRatingDetails(ProductDetailsModel productDetailsModel,ProductRatingModel productRatingModel, 
			CatalogModel catalogModel, String id) {
		
		System.out.println("inside class ProductCatalogBusiness, method getPoductNRatingDetails");
		 catalogModel = new CatalogModel(); 
		if(null!=productDetailsModel && null!= productDetailsModel.getProductId() &&
				productDetailsModel.getProductId().equals(id)) {
			System.out.println("Product id :: "+productDetailsModel.getProductId());
			catalogModel.setProductId(productDetailsModel.getProductId());
			if(null!=productDetailsModel.getName()) {
				System.out.println("Product name :: "+productDetailsModel.getName());
				catalogModel.setName(productDetailsModel.getName());
			}
			if(null!=productDetailsModel.getProductDetails()) {
				System.out.println("Product details :: "+productDetailsModel.getProductDetails());
				catalogModel.setProductDetails(productDetailsModel.getProductDetails());
			}
			if(null!=productDetailsModel.getRelease_date()) {
				System.out.println("Product release date :: "+productDetailsModel.getRelease_date());
				catalogModel.setRelease_date(productDetailsModel.getRelease_date());
			}
		}
		if(null!=productRatingModel && null!= productDetailsModel.getProductId() &&
				productRatingModel.getProductId().equals(id)) {
			if(null!=productRatingModel.getRating()) {
				System.out.println("product rating out of 10 is "+productRatingModel.getRating());
				catalogModel.setRating(productRatingModel.getRating());
			}
			if(null!=productRatingModel.getCountOfVoters()) {
				System.out.println("numer of user gave rating :: "+productRatingModel.getCountOfVoters());
				catalogModel.setCountOfVoters(productRatingModel.getCountOfVoters());
			}
		}
		if(null!=productRatingModel && null==productDetailsModel.getProductId()) {
			System.out.println("Your provided id in url is wrong, please provide a correct id");
			catalogModel.setError("Your provided id in url is wrong, please provide a correct id");
		}
		System.out.println("retuning the object "+catalogModel);
		return catalogModel;
	}
}
