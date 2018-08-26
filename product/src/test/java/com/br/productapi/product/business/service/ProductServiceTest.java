package com.br.productapi.product.business.service;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static com.br.productapi.product.enuns.SearchFilter.ALL;
import static java.util.Optional.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.br.productapi.product.entity.ProductEntity;
import com.br.productapi.product.exception.ServiceException;
import com.br.productapi.product.model.Product;
import com.br.productapi.product.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	private PageRequest pageRequst;
	private static final String TEMPLATES_PATH = "com.br.productapi.product.templates";
	
	@Mock
	private ProductRepository repository;

	@InjectMocks
	private ProductService service;
	
	@Before
	public void init() {
		loadTemplates(TEMPLATES_PATH);
		this.pageRequst = PageRequest.of(0, 1);
	}
	
	// getProducts - devolve IllegalArgumentException quando texto é nulo
	@Test(expected = IllegalArgumentException.class)
	public void shouldGetProductsThorwIllegalArgumentExceptionWhenTextIsNull() 
			throws Exception {
		// GIVEN
		String text = null;
		List<Product> result = new ArrayList<>();
		
		try {
			// WHEN
			result = service.getProducts(text, pageRequst);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}
	}
	
	// getProducts - devolve IllegalArgumentException quando texto e vazio
	@Test(expected = IllegalArgumentException.class)
	public void shouldGetProductsThrowIllegalArgmentExceptionWhenTextIsEmpty() 
			throws Exception {
		// GIVEN
		String text = "";
		List<Product> result = new ArrayList<>();
		
		try {
			// WHEN
			result = service.getProducts(text, pageRequst);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}
	}
	
	// getProducts - devolve IllegalArgumentException quando Pageable é nulo
	@Test(expected = IllegalArgumentException.class)
	public void shouldGetProductThrowIllegalArgumentExceptionWhenPageableIsNull() 
			throws Exception {
		// GIVEN
		String text = "test-01";
		List<Product> result = new ArrayList<>();
		
		try {
			// WHEN
			result = service.getProducts(text, null);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}	
	}
	
	// getProducts - devolve ServiceException quando acontecer algum problema com a busca no repository
	@Test(expected = ServiceException.class)
	public void shouldGetProductThrowServiceExceptionWhenRepositoryThrowSomeException() 
			throws Exception {
		// GIVEN
		String text = "test-01";
		List<Product> result = new ArrayList<>();
		
		when(repository.getProductsByText(text, pageRequst))
		.thenThrow(new DataAccessResourceFailureException("ERRO!"));
		
		try {
			// WHEN
			result = service.getProducts(text, pageRequst);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}		
	}
	
	// getProducts - retorna uma Lista de Products
	@Test
	public void shouldGetProductReturnListOfProductsWhenTextParamValueIsNotALL() 
			throws ServiceException {
		// GIVEN
		String text = "test-01";
		List<Product> result = new ArrayList<>();
		
		Optional<List<ProductEntity>> repoResult = of(
				from(ProductEntity.class)
				.gimme(1, "product-entity-test-01"));
		
		when(repository.getProductsByText(text, pageRequst))
		.thenReturn(repoResult);
		
		// WHEN
		result = service.getProducts(text, pageRequst);

		// THEN
		verify(repository, never()).findAll();
		verify(repository, times(1)).getProductsByText(text, pageRequst);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		
		for (Product p : result) {
			assertNotNull(p.getId());
			
			assertNotNull(p.getName());
			assertFalse(p.getName().isEmpty());

			assertNotNull(p.getCategory());
			assertFalse(p.getCategory().isEmpty());
			
			assertNotNull(p.getPriceFrom());
			assertNotNull(p.getPriceTo());
			
			assertNotNull(p.getImages());
			assertFalse(p.getImages().isEmpty());
			
			assertNotNull(p.getSearchBy());
			assertFalse(p.getSearchBy().isEmpty());
		}
	}
	
	@Test
	public void shouldGetProductReturnListOfProductsWhenTextParamValueIstALL() 
			throws ServiceException {
		// GIVEN
		String text = ALL.name();
		List<Product> result = new ArrayList<>();
		
		List<ProductEntity> repoResult = from(ProductEntity.class)
				.gimme(1, "product-entity-test-01");
		
		when(repository.findAll()).thenReturn(repoResult);
		
		// WHEN
		result = service.getProducts(text, pageRequst);

		// THEN
		verify(repository, times(1)).findAll();
		verify(repository, never()).getProductsByText(anyString(), any(Pageable.class));
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		
		for (Product p : result) {
			assertNotNull(p.getId());
			
			assertNotNull(p.getName());
			assertFalse(p.getName().isEmpty());

			assertNotNull(p.getCategory());
			assertFalse(p.getCategory().isEmpty());
			
			assertNotNull(p.getPriceFrom());
			assertNotNull(p.getPriceTo());
			
			assertNotNull(p.getImages());
			assertFalse(p.getImages().isEmpty());
			
			assertNotNull(p.getSearchBy());
			assertFalse(p.getSearchBy().isEmpty());
		}
	}
	
}
