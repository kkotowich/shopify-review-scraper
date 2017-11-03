/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learning.reviewfetcher.Review;
import com.learning.reviewfetcher.ReviewFetcher;

public class ReviewFetcherTest {
	
	ReviewFetcher reviewScraper;

	@Before
	public void setUp() throws Exception {
		reviewScraper = new ReviewFetcher();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<Review> reviews;
		
		try {
			reviews = reviewScraper.fetchAllReviews("product-upsell");
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
		
		assert(true);
	}

}
