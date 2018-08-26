package com.br.productapi.product.business;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.productapi.product.business.service.ProductService;
import com.br.productapi.product.model.Product;

@Service
public class ProductBusiness {

	private ProductService service;
	
	@Autowired
	public ProductBusiness(ProductService service) {
		this.service = service;
	}

	/**
	 * 
	 * @param text
	 * @param object
	 * @return
	 */
	public List<Product> getProducts(String text, Pageable pageable) {
		hasText(text, "Parâmetro 'text' não deve ser nulo ou vazio!");
		notNull(pageable, "Paraâmetro 'pageable' não deve ser nulo!");
		
		List<Product> result = new ArrayList<>();
		
		try {
			result.addAll(service.getProducts(text, pageable));
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return result;
	}
	
	
	
}
