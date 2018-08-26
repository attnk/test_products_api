package com.br.productapi.product.controller;

import static com.br.productapi.product.enuns.SearchFilter.ALL;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.productapi.product.business.ProductBusiness;
import com.br.productapi.product.model.Product;

@RestController
@RequestMapping(value="/", produces=APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

	private static final Logger LOG = getLogger(ProductController.class);
	
	@Autowired
	private ProductBusiness business;
	
	@GetMapping(path="/products")
	public ResponseEntity<List<Product>> getProductList(
			@RequestParam(name="text", required=false) String text, 
			@PageableDefault(size = 5) Pageable pageable) {
		LOG.info("INICIANDO BUSCA DE DADOS: GET");
		
		return (Objects.isNull(text) || text.isEmpty()) ? 
				business.getProducts(ALL.name(), pageable) : business.getProducts(text, pageable);
	}
}
