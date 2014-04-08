package com.sjsu.restclient;



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sjsu.pojo.User;

public class RestClient {

	
	public static void main(String args[])
	{
		//addUser();
		//editUser();
		deleteUser();
	}
	
	
	public static void addUser() {

		try
		{
			User user = new User();
			user.setCity("sanjose");
			user.setName("vallividhya");
			user.setEmail("valli.vidhya@gmail.com");
			user.setZip(95051);
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/adduser");
			Response response = target.request().post(Entity.entity(user, "application/json"));
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) );
			}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void editUser() {
		try
		{
			User user = new User();
			user.setCity("sanjose");
			user.setName("vallividhyaedited");
			user.setEmail("valli.vidhya@gmail.com");
			user.setZip(95051);
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/edituser");
			Response response = target.request().post(Entity.entity(user, "application/json"));
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) );
				}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void deleteUser() {
		try
		{
			User user = new User();
			user.setEmail("valli.vidhya@gmail.com");
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/deleteuser");
			Response response = target.request().post(Entity.entity(user, "application/json"));
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) );
			}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static void testGet() {

		try
		{
			User user = new User();
			user.setName("latchu");
			ResteasyClient client = new ResteasyClientBuilder().build();

			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/jsonServices/print");

			
			Response response = target.request().get();

			if (response.getStatus() != 200) {

				throw new RuntimeException("Failed : HTTP error code : "

			                        + response.getStatus());

			}

			System.out.println("Server response : \n");

			System.out.println(response.readEntity(String.class));

			response.close();

		} catch (Exception e) {

			e.printStackTrace();

		}



	}


}
