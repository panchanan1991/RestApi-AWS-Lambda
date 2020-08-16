package io.start.awslambda.poductratingservice.productratingservice.service;

import org.springframework.web.client.RestTemplate;

import io.start.awslambda.poductratingservice.productratingservice.business.ProductRatingBusiness;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingsModelTO;

/**
 * @author Panchanan
 * This class is Service class of the product rating service
 *
 */
public class ProductRatingService {

	private String apikey="61f1a139b6cede3e8beecaf623ff411d";


	ProductRatingBusiness productRatingBusiness= new ProductRatingBusiness();

	//Logger Log = LoggerFactory.getLogger(ProductRatingService.class);

	RestTemplate restTemplate = new RestTemplate();

	public ProductRatingModel getProductRating(String id) {

		
		ProductRatingsModelTO productRatingsModelTO= new ProductRatingsModelTO();
		System.out.println("Inside getProductRating method in service layer ");
		
		 System.out.println("The url is -- https://api.themoviedb.org/3/movie/"
		 +id+"?api_key="+apikey+" for calling the external rest API");
		 
		try {
			System.out.println("calling external rest api ..themoviedb ");
			productRatingsModelTO = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey,
					ProductRatingsModelTO.class);
		} catch (Exception e) {
			System.out.println("getting eror msg.."+e.getMessage());
			productRatingsModelTO.setId("200");
			productRatingsModelTO.setImdb_id("214578");
			productRatingsModelTO.setVote_average("8.5");
			
		}

		return productRatingBusiness.getProductRating(productRatingsModelTO);
	}
}
