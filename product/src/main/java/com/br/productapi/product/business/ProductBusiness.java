package com.br.productapi.product.business;

import static java.lang.String.valueOf;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.productapi.product.business.service.ProductService;
import com.br.productapi.product.model.Product;

@Service
public class ProductBusiness {

	private static final Logger LOG = getLogger(ProductBusiness.class);
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
	public ResponseEntity<List<Product>> getProducts(String text, Pageable pageable) {
		hasText(text, "Parâmetro 'text' não deve ser nulo ou vazio!");
		notNull(pageable, "Paraâmetro 'pageable' não deve ser nulo!");
		
		LOG.info("DADOS: text="+ text +
				"|| pag="+ pageable.getPageNumber() +
				"|| itens="+ pageable.getPageSize());

		List<Product> result = new ArrayList<>();
		
		try {
			result.addAll(service.getProducts(text, pageable));
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-Paging-Total-Entries", valueOf(result.size()));
			headers.add("X-Paging-Entries-Per-Page", valueOf(pageable.getPageSize()));
			headers.add("X-Paging-Current-Page", valueOf(pageable.getPageNumber()));
			headers.add("X-Paging-Total-Pages", valueOf(result.size() / pageable.getPageSize()));
			
			return new ResponseEntity<List<Product>>(result, headers, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("FALHA AO REALIZAR A BUSCA!", e);
			throw new BusinessException(e);
		}
	}
	
}
