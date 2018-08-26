package com.br.productapi.product.templates.model;

import static java.util.Arrays.asList;

import java.math.BigDecimal;

import com.br.productapi.product.model.Product;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProductTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Product.class).addTemplate("product-default", new Rule() {{
			add("id", 0L);
			add("name", "");
			add("category", "");
			add("size", "");
			add("priceFrom", new BigDecimal("0.00"));
			add("priceTo", new BigDecimal("0.00"));
			add("images", asList("https://image.com/image-default.jpg"));
			add("searchBy", "");
		}});

		// ----------------------
		
		Fixture.of(Product.class).addTemplate("product-test-01", new Rule() {{
			add("id", 1L);
			add("name", "test-01");
			add("category", "categ-test-01");
			add("size", "size-test-01");
			add("priceFrom", new BigDecimal("100.00"));
			add("priceTo", new BigDecimal("80.00"));
			add("images", asList(
					"https://image.com/image-01.jpg", 
					"https://image.com/image-02.jpg", 
					"https://image.com/image-03.jpg", 
					"https://image.com/image-04.jpg"));
			add("searchBy", "test-01");
		}});
		
	}

}
