package io.start.awslambda.poductratingservice.productratingservice.business;

import org.springframework.stereotype.Component;

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
	private ProductRatingModel getProduct(ProductRatingsModelTO productRatingsModelTO) {
		
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
}
