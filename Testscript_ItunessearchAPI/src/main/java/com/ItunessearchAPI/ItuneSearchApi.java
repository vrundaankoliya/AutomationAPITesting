package com.ItunessearchAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItuneSearchApi {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {


	}

	public static String helloWorld() throws ClientProtocolException, IOException{

		String url = "https://itunes.apple.com/search?term=jack+johnson";
		HttpClient client = HttpClientBuilder.create().build();// create client
		HttpGet request = new HttpGet(url); // invoke method
		HttpResponse response = client.execute(request); // get response
		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode()); // got status code
		// System.out.println(response.getEntity().getContent());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));// converting bytestream to string
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			// parsing To take particular element we use parsing
		}
		// using json jeckson we can find particular element like id,results,..
		String result1 = new String(result);
		System.out.println(result);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(result1).get("results").get(0)
				.get("collectionId");
		String s = node.asText();
		return s;
	}
}
