package com.br.productapi.product.business;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.PageRequest;

import com.br.productapi.product.business.service.ProductService;
import com.br.productapi.product.exception.ServiceException;
import com.br.productapi.product.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductBusinesTest {

	private PageRequest pageRequst;
	private static final String TEMPLATES_PATH = "com.br.productapi.product.templates";
	
	@Mock
	private ProductService service;
	
	@InjectMocks
	private ProductBusiness business;
	
	@Before
	public void init() {
		loadTemplates(TEMPLATES_PATH);
		this.pageRequst = PageRequest.of(0, 10);
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
			result = business.getProducts(text, pageRequst);
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
			result = business.getProducts(text, pageRequst);
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
			result = business.getProducts(text, null);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}	
	}
	
	// getProducts - devolve BusinessException quando service devolve ServiceException
	@Test(expected = BusinessException.class)
	public void shouldGetProductThrowServiceExceptionWhenRepositoryThrowSomeException() 
			throws Exception {
		// GIVEN
		String text = "test-01";
		List<Product> result = new ArrayList<>();
		
		when(service.getProducts(text, pageRequst))
		.thenThrow(new ServiceException(
				"ERRO!", 
				new DataAccessResourceFailureException("ERRO DB!!")));
		
		try {
			// WHEN
			result = business.getProducts(text, pageRequst);
		} catch (Exception e) {
			// THEN
			assertTrue(result.isEmpty());
			throw e;
		}	
	}
	
	// getProducts - retorna uma Lista de Products
	@Test
	public void shouldGetProductReturnListOfProductsWhenEverythingIsOk() 
			throws ServiceException {
		// GIVEN
		String text = "test-01";
		List<Product> result = new ArrayList<>();
		
		List<Product> serviceResult = from(Product.class)
				.gimme(1, "product-test-01");
		
		when(service.getProducts(text, pageRequst))
		.thenReturn(serviceResult);
		
		// WHEN
		result = service.getProducts(text, pageRequst);

		// THEN
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
