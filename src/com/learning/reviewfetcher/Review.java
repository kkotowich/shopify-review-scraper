package com.learning.reviewfetcher;

public class Review {
	
	String author;
	String body;
	String createdAt;
	String shopDomain;
	String shopName;
	int rating;
	
	public Review(String author, String body, String createdAt, String shopDomain, String shopName, int rating) {
		super();
		this.author = author;
		this.body = body;
		this.createdAt = createdAt;
		this.shopDomain = shopDomain;
		this.shopName = shopName;
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getShopDomain() {
		return shopDomain;
	}

	public void setShopDomain(String shopDomain) {
		this.shopDomain = shopDomain;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [author=" + author + ", body=" + body + ", createdAt=" + createdAt + ", shopDomain=" + shopDomain
				+ ", shopName=" + shopName + ", rating=" + rating + "]";
	}
	
	

}
