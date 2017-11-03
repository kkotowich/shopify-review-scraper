package com.learning.reviewfetcher;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

public class Main {

	public static void main(String[] args) throws IOException, JSONException, ParseException {
		
		ReviewFetcher fetcher = new ReviewFetcher();
		ArrayList<Review> reviews;
		
		reviews = fetcher.fetchAllReviews("product-upsell");
		
		System.out.println(reviews.get(1));

	}

}
