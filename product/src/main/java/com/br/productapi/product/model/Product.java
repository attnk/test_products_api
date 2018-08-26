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
	private String searchBy;

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

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	
	public Product withSearchBy(String searchBy) {
		this.searchBy = searchBy;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priceFrom == null) ? 0 : priceFrom.hashCode());
		result = prime * result + ((priceTo == null) ? 0 : priceTo.hashCode());
		result = prime * result + ((searchBy == null) ? 0 : searchBy.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceFrom == null) {
			if (other.priceFrom != null)
				return false;
		} else if (!priceFrom.equals(other.priceFrom))
			return false;
		if (priceTo == null) {
			if (other.priceTo != null)
				return false;
		} else if (!priceTo.equals(other.priceTo))
			return false;
		if (searchBy == null) {
			if (other.searchBy != null)
				return false;
		} else if (!searchBy.equals(other.searchBy))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
}
