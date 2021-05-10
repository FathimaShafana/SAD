package com.exam.sad;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FinalExamApplication {

	static HttpClient client = HttpClient.newHttpClient();
	static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(FinalExamApplication.class, args);
		//Product pro1 = mapper.readValue(pro1.getName(), pro1.getClass());
	//	pro1.setName("Product1");
		
		//GET
				final Product p1;
				//Set<Product> products=p1.getName();
				
				//String productName=prod
				String Product = get(1);
				Product pro = mapper.readValue(Product, Product.class);
				pro.setName("Product1");
						
				//GET
				String jsonPowerPoint2 = get(1);
				Product pro2 = mapper.readValue(jsonPowerPoint2, Product.class);
				pro2.setName("Product2");
						
				//PUT (the version will increment automatically)
				update(convertObjToJSON(pro));
	}
			
			private static String get(int id) throws IOException, InterruptedException {
				HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create("http://localhost:8080/products/" + id))
		                .setHeader("User-Agent", "Java 11 HttpClient Bot") //optional line
		                .build();
				System.out.println("Get request: " + sendRequest(request).toString());
				return sendRequest(request);
			}
			
			private static void insert(int id, int stock) 
					throws IOException, InterruptedException {
				
		        String json = makeJSON(id, stock);
		        
		        HttpRequest request = HttpRequest.newBuilder()
		        		.POST(HttpRequest.BodyPublishers.ofString(json)) //.POST accepts a BodyPublisher
		        		.uri(URI.create("http://localhost:8080/products"))
		        		.setHeader("User-Agent", "Java 11 HttpClient Bot")
		        		.header("Content-Type", "application/json")
		        		.build();
		        
		        System.out.println("Inserted: " + sendRequest(request));
		        
			}
			
		
			private static void update(String jsonString) throws IOException, 
			InterruptedException {
		        HttpRequest request = HttpRequest.newBuilder()
		        		.PUT(HttpRequest.BodyPublishers.ofString(jsonString))
		        		.uri(URI.create("http://localhost:8080/products/"))
		        		.setHeader("User-Agent", "Java 11 HttpClient Bot")
		        		.header("Content-Type", "application/json")
		        		.build();
		        System.out.println("Put request: " + sendRequest(request).toString());
		       
			}
			
			//User defined to make JSON file
			private static String makeJSON(int id, int stock) {
				String json = new StringBuilder()
		                .append("{")
		                .append("\"Product\":\"" + id + "\",")
		                .append("\"stock\":\"" + stock + "\"")
		                .append("}").toString();
				return json;
			}
			
			private static String sendRequest(HttpRequest request) throws IOException, 
			InterruptedException{
				HttpResponse<String> response = 
		        		client.send(request, HttpResponse.BodyHandlers.ofString());
		        return response.body();
			}
			
			//Java object to JSON
			private static String convertObjToJSON(Product product) throws 
			JsonProcessingException {
				String jsonString = mapper.writeValueAsString(product);
				return jsonString;
			}

}

