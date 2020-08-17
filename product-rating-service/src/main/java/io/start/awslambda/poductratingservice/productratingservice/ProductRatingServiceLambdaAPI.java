package io.start.awslambda.poductratingservice.productratingservice;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import io.start.awslambda.poductratingservice.productratingservice.model.AWSLambdaPojo;
import io.start.awslambda.poductratingservice.productratingservice.model.CatalogModel;
import io.start.awslambda.poductratingservice.productratingservice.service.ProductRatingService;
/**
 * This class is business class of the product rating service
 * @author Panchanan mal
 *
 */
public class ProductRatingServiceLambdaAPI implements RequestHandler<AWSLambdaPojo, CatalogModel>{
	
	
	//ProductRatingService productRatingService= new ProductRatingService();
	
	/**
	 * This method is the handle request for AWS Lambda API GateWay
	 * @param id AWSLambdaPojo, Context
	 * @return ProductRatingModel
	 */
	ProductRatingService productRatingService2= new ProductRatingService();
	@Override
	public CatalogModel handleRequest(AWSLambdaPojo req, Context context) {
		
		ProductRatingService productRatingService= new ProductRatingService();
		System.out.println("Inside handleRequest method");
		CatalogModel catalogModel = null;

		try{
			System.out.println("Calling servie layer with id"+ req.getId());
			catalogModel = productRatingService.
					getProductRating(req.getId());
		} catch (Exception e) {
			System.out.println("Getting message..."+e.getMessage());
		}
		System.out.println("retuning the object ");
		return catalogModel;
	}
	
	public static void main(String[] ags) {
		ProductRatingService productRatingService= new ProductRatingService();
		productRatingService.getProductRating("400");
	}
}
