package com.iasri.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class ProductClient {
	private static String BaseURI="http://localhost:8080/MyWebsites/rest/products";
	public static void main(String[] args) {
        testlist();
        //testAdd();
        //testGet();
        //testUpdate();
        testDelete();
        testlist();
	}
	
	static void testAdd(){
		WebTarget target=getWebTarget();
		Product product=new Product("iGlass",99.99f);
		Response response=target.request().post(Entity.entity(product, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response);
	}
	
	static void testDelete(){
		WebTarget target=getWebTarget();
		String productId="3";
		Response response=target.path(productId).request().get(Response.class);
		System.out.println(response);
	}
	
	static void testUpdate(){
		WebTarget target=getWebTarget();
		String productId="1";
		Product product=new Product("iPhoneXX",90.91f);
		Response response=target.path(productId).request().put(Entity.entity(product, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response);
	}
	
	static void testGet(){
		WebTarget target=getWebTarget();
		String productId="2";
		Product product=target.path(productId).request().accept(MediaType.APPLICATION_JSON).get(Product.class);		
		System.out.println(product);		
	}
	
	static void testlist(){
		WebTarget target=getWebTarget();
		String response=target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}
	
	static WebTarget getWebTarget(){
		ClientConfig config=new ClientConfig();
		Client client=ClientBuilder.newClient(config);		
		WebTarget target=client.target(BaseURI);
		return target;
	}
}
