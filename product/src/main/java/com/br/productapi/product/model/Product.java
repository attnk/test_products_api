package com.br.productapi.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private List<String> images;
	private String serachBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
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

	public BigDecimal getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(BigDecimal priceFrom) {
		this.priceFrom = priceFrom;
	}

	public BigDecimal getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(BigDecimal priceTo) {
		this.priceTo = priceTo;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getSerachBy() {
		return serachBy;
	}

	public void setSerachBy(String serachBy) {
		this.serachBy = serachBy;
	}
	
}
