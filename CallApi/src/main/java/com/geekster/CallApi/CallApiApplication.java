package com.geekster.CallApi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CallApiApplication {
	public static void main(String[] args) {
		try {
			// Set the URL of the API endpoint
			URL url = new URL("https://api.zippopotam.us/us/33162");

			// Open a connection to the API endpoint
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Read the response from the API
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder responseBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				responseBuilder.append(line);
			}
			reader.close();

			// Convert the response to JSON format
			String json = responseBuilder.toString();

			// Print the JSON data
			System.out.println(json);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
