package io.start.awslambda.poductratingservice.productratingservice.service;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import io.start.awslambda.poductratingservice.productratingservice.business.ProductRatingBusiness;
import io.start.awslambda.poductratingservice.productratingservice.model.CatalogModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductDetailsModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductDetailsModelTO;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingModel;
import io.start.awslambda.poductratingservice.productratingservice.model.ProductRatingsModelTO;
/**
 * @author Panchanan
 * This class is Service class of the product rating service
 *
 */
public class ProductRatingService {

	private String apikey="61f1a1XXXXXXXXXXXaf623ff411d";


	ProductRatingBusiness productRatingBusiness= new ProductRatingBusiness();

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * @param id
	 * @return CatalogModel
	 */
	public CatalogModel getProductRating(String id) {
		
		  MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
		  MappingJackson2HttpMessageConverter();
		  mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
		  MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		  restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		 
		CatalogModel  catalogModel = null;
		ProductRatingsModelTO productRatingsModelTO1=null;
		ProductDetailsModelTO productDetailsModelTO2 =null;
		System.out.println("Inside getProductRating method in service layer ");
		
		 System.out.println("The url is -- https://api.themoviedb.org/3/movie/"
		 +id+"?api_key="+apikey+" for calling the external rest API");
		 		 
		try {
			System.out.println("calling external rest api ..themoviedb ");
			productRatingsModelTO1 = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey,
					ProductRatingsModelTO.class);
			productDetailsModelTO2 = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey,
					ProductDetailsModelTO.class);
			
		} catch (Exception e) {
			System.out.println("getting eror msg.."+e.getMessage());			
		}
		ProductRatingModel productRatingModel =  productRatingBusiness.getProductRating(productRatingsModelTO1);
		ProductDetailsModel productDetailsModel = productRatingBusiness.getProduct2(productDetailsModelTO2);
		return productRatingBusiness.getPoductNRatingDetails(productDetailsModel, productRatingModel, catalogModel, id);
	}
}
