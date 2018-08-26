package com.br.productapi.product.templates.entity;

import java.math.BigDecimal;

import com.br.productapi.product.entity.ProductEntity;
import com.br.productapi.product.entity.ProductImagesEntity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProductEntityTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(ProductEntity.class).addTemplate("product-entity-default", new Rule() {{
			add("id", 0L);
			add("name", "");
			add("category", "");
			add("size", "");
			add("priceFrom", new BigDecimal("0.00"));
			add("priceTo", new BigDecimal("0.00"));
			add("images", has(1).of(ProductImagesEntity.class, "product-images-entity-default"));
		}});
		
		// -----------------------

		Fixture.of(ProductEntity.class).addTemplate("product-entity-test-01", new Rule() {{
			add("id", 1L);
			add("name", "test-01");
			add("category", "categ-test-01");
			add("size", "size-test-01");
			add("priceFrom", new BigDecimal("100.00"));
			add("priceTo", new BigDecimal("80.00"));
			add("images", has(4).of(ProductImagesEntity.class, 
					"product-images-entity-test-01",
					"product-images-entity-test-02",
					"product-images-entity-test-03",
					"product-images-entity-test-04"));
		}});
		
	}

}
