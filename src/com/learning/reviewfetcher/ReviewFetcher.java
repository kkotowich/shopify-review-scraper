package com.learning.reviewfetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReviewFetcher {
	
	public ReviewFetcher() {}
	
	public ArrayList<Review> fetchAllReviews(String appName) throws IOException, JSONException, ParseException {
		HttpURLConnection urlConnection;
		JSONArray jsonArr;
		ArrayList<Review> reviews;
		
		urlConnection = buildConnection(appName);
		jsonArr = getHttpResults(urlConnection);
		reviews = createReviewsFromJSONArray(jsonArr);

		return reviews;
	}
	
	private HttpURLConnection buildConnection(String appName) throws IOException {
		URL url;
		HttpURLConnection urlConnection;
		
		url = new URL("https://apps.shopify.com/" + appName + "/reviews.json");
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		
		return urlConnection;
	}
	
	private JSONArray getHttpResults(HttpURLConnection urlConnection) throws IOException {
		BufferedReader bReader;
		StringBuilder result = new StringBuilder();
		
		bReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while ((line = bReader.readLine()) != null) {
			result.append(line);
		}
		bReader.close();
		
		return stringToJson(result.toString());
	}
	
	private JSONArray stringToJson(String from) {
		JSONObject jsonObj;
		
		jsonObj = new JSONObject(from);
		
		return jsonObj.getJSONArray("reviews");
	}
	
	private ArrayList<Review> createReviewsFromJSONArray(JSONArray jsonArr) throws JSONException, ParseException {
		ArrayList<Review> reviews = new ArrayList<>();

		for (int i = 0; i < jsonArr.length(); i++){
			reviews.add(createReviewFromJsonObject(jsonArr.getJSONObject(i)));
		}
		
		return reviews;
	}
	
	private Review createReviewFromJsonObject(JSONObject jsonObj) throws JSONException, ParseException {
		String author;
		String body;
		String createdAt;
		String shopDomain;
		String shopName;
		int starRating;
		
		try {
			author = jsonObj.getString("author");
		}
		catch(JSONException jsonE ) {
			author = null;
		}
		body = jsonObj.getString("body");
		createdAt = jsonObj.getString("created_at");
		shopDomain = jsonObj.getString("shop_domain");
		shopName = jsonObj.getString("shop_name");
		starRating = jsonObj.getInt("star_rating");
		
		return new Review(author, body, createdAt, shopDomain, shopName, starRating);
	}
}
