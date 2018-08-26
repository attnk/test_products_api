package com.br.productapi.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity implements Serializable {
	
	private static final long serialVersionUID = -4788933430058589368L;

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String category;
	
	@Column
	private String size;

	@Column(name="price_from")
	private BigDecimal priceFrom;
	
	@Column(name="price_to")
	private BigDecimal priceTo;
	
	@OneToMany
	@JoinColumn(name= "product_id")
	private List<ProductImagesEntity> images = new ArrayList<>();

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

	public String getCategry() {
		return category;
	}

	public void setCategry(String category) {
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

	public List<ProductImagesEntity> getImages() {
		return images;
	}

	public void setContacts(List<ProductImagesEntity> images) {
		this.images = images;
	}
	
}
