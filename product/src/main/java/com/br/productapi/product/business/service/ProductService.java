package com.br.productapi.product.business.service;

import static com.br.productapi.product.enuns.SearchFilter.ALL;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.productapi.product.entity.ProductEntity;
import com.br.productapi.product.entity.ProductImagesEntity;
import com.br.productapi.product.exception.ServiceException;
import com.br.productapi.product.model.Product;
import com.br.productapi.product.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	/**
	 * Realiza a busca np banco, retorna a lista de Product 
	 * 
	 * @param text
	 * @param pageRequst
	 * @return
	 * @throws ServiceException 
	 */
	public List<Product> getProducts(String text, Pageable pageable) throws ServiceException {
		hasText(text, "Parâmetro 'text' não deve ser nulo ou vazio!");
		notNull(pageable, "Paraâmetro 'pageable' não deve ser nulo!");
		
		List<Product> result;
		
		try {
			List<ProductEntity> dbResult = ALL.name().equals(text) ? 
					repository.findAll() : repository.getProductsByText(text, pageable).get();
					
			result = getProductsList(text, dbResult);
		} catch(NoSuchElementException e) {
			result = new ArrayList<>();
		} catch (Exception e) {
			throw new ServiceException(
					"Falha ao retornar dados da base:"+ e.getMessage(),
					e);
		}
		
		return result;
	}

	private List<Product> getProductsList(String text, List<ProductEntity> dbResult) {
		Set<Product> products = new HashSet<>();
		
		dbResult.stream().forEach(p -> {
			Product product = new Product();
			
			product.withId(p.getId())
			.withName(p.getName())
			.withCategory(p.getCategry())
			.withSize(p.getSize())
			.withPriceFrom(p.getPriceFrom())
			.withPriceTo(p.getPriceTo())
			.withImages(
					p.getImages()
					.stream()
					.map(ProductImagesEntity::getUrl)
					.collect(Collectors.toList()))
			.withSearchBy(text);
			
			products.add(product);
		});
		
		return new ArrayList<>(products);
	}
	
}
