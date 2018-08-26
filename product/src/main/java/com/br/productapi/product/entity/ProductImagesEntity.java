package com.br.productapi.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_images", schema="product")
public class ProductImagesEntity implements Serializable {

	private static final long serialVersionUID = -5901949122967613264L;

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productId;
	
	@Column
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
