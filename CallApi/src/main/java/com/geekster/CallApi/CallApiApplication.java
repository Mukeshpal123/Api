package com.geekster.CallApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class CallApiApplication {

	public static void main(String[] args) throws IOException, IOException {
		// Create URL object for the API endpoint
		URL url = new URL("https://api.chucknorris.io/jokes/random");

		// Open HTTP connection
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// Get response code
		int responseCode = conn.getResponseCode();
		System.out.println("Response code: " + responseCode);

		// Read response body
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuilder responseBody = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			responseBody.append(inputLine);
		}
		in.close();

		// Print response body
		System.out.println("Response body: " + responseBody.toString());
	}

}
