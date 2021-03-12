package com.aio;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClientRequest request = new ClientRequest("http://localhost:8090/aio/rest/student/getallstudent");
			request.accept("application/json");

			ClientResponse<String> response = request.get(String.class);
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));
			
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
