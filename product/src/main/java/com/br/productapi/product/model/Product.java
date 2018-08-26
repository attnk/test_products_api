package com.br.productapi.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
	"id", 
	"name", 
	"category", 
	"size", 
	"priceFrom", 
	"priceTo", 
	"images", 
	"searchBy"})
public class Product implements Serializable {

	private static final long serialVersionUID = -4726386500153149894L;
	
	private Long id;
	private String name;
	private String category;
	private String size;
	private BigDecimal priceFrom;
	private BigDecimal priceTo;
	private List<String> images = new ArrayList<>();
	private String serachBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product withId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product withName(String name) {
		this.name = name;
		return this;
	}
	
	public String getCategory() {
		return category;
	}

	public Product withCategory(String category) {
		this.category = category;
		return this;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Product withSize(String size) {
		this.size = size;
		return this;
	}
	
	public BigDecimal getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(BigDecimal priceFrom) {
		this.priceFrom = priceFrom;
	}

	public Product withPriceFrom(BigDecimal priceFrom) {
		this.priceFrom = priceFrom;
		return this;
	}
	
	public BigDecimal getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(BigDecimal priceTo) {
		this.priceTo = priceTo;
	}

	public Product withPriceTo(BigDecimal priceTo) {
		this.priceTo = priceTo;
		return this;
	}
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	public Product withImages(List<String> images) {
		this.images.addAll(images);
		return this;
	}

	public String getSerachBy() {
		return serachBy;
	}

	public void setSerachBy(String serachBy) {
		this.serachBy = serachBy;
	}
	
	public Product withSerachBy(String searchBy) {
		this.serachBy = searchBy;
		return this;
	}
	
}
