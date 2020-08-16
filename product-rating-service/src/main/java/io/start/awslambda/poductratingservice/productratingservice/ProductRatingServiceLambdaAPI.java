package io.start.awslambda.poductratingservice.productratingservice;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import io.start.awslambda.poductratingservice.productratingservice.model.AWSLambdaPojo;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingModel;
import io.start.awslambda.poductratingservice.productratingservice.service.ProductRatingService;
/**
 * This class is business class of the product rating service
 * @author Panchanan mal
 *
 */
public class ProductRatingServiceLambdaAPI implements RequestHandler<AWSLambdaPojo, ProductRatingModel>{
	
	
	ProductRatingService productRatingService= new ProductRatingService();
	
	/**
	 * This method is the handle request for AWS Lambda API GateWay
	 * @param id AWSLambdaPojo, Context
	 * @return ProductRatingModel
	 */
	@Override
	public ProductRatingModel handleRequest(AWSLambdaPojo req, Context context) {

		System.out.println("Inside handleRequest method");
		ProductRatingModel productRatingMode = null;

		try{
			System.out.println("Calling servie layer with id"+ req.getId());
			productRatingMode = productRatingService.
					getProductRating(req.getId());
		} catch (Exception e) {
			System.out.println("Getting message..."+e.getMessage());
		}
		System.out.println("retuning the object ");
		return productRatingMode;
	}
}
