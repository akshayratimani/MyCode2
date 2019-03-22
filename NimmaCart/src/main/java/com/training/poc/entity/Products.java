package com.training.poc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	private String name;
	@Id
	private int id;
	private String category;
	private String ratings;
	private String price;
	private String imgurl;
	
	public Products() {

	}

	public Products(String name, int id, String category, String ratings, String price, String imgurl) {
		super();
		this.name = name;
		this.id = id;
		this.category = category;
		this.ratings = ratings;
		this.price = price;
		this.imgurl = imgurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", id=" + id + ", category=" + category + ", ratings=" + ratings + ", price="
				+ price + ", imgurl=" + imgurl + "]";
	}
	
	   

}
