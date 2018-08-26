package com.br.productapi.product.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = -4788933430058589368L;

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String category;
	
	@Column
	private String size;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@OneToMany
	@JoinColumn(name= "product_id")
	private List<ProductImages> images = new ArrayList<>();

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

	public List<ProductImages> getContacts() {
		return images;
	}

	public void setContacts(List<ProductImages> images) {
		this.images = images;
	}
	
}
