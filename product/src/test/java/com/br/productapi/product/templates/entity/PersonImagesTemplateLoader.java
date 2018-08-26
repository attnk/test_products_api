package com.br.productapi.product.templates.entity;

import com.br.productapi.product.entity.ProductEntity;
import com.br.productapi.product.entity.ProductImagesEntity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PersonImagesTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(ProductImagesEntity.class).addTemplate("product-images-entity-default", new Rule() {{
			add("id", 0L);
			add("productId", new ProductEntity());
			add("url", "https://iamge.com/image-default.jpg");
		}});

		// ----------------
		
		Fixture.of(ProductImagesEntity.class).addTemplate("product-images-entity-test-01", new Rule() {{
			add("id", 1L);
			add("productId", new ProductEntity());
			add("url", "https://iamge.com/image-01.jpg");
		}});
		
		Fixture.of(ProductImagesEntity.class).addTemplate("product-images-entity-test-02", new Rule() {{
			add("id", 2L);
			add("productId", new ProductEntity());
			add("url", "https://iamge.com/image-02.jpg");
		}});
		
		Fixture.of(ProductImagesEntity.class).addTemplate("product-images-entity-test-03", new Rule() {{
			add("id", 3L);
			add("productId", new ProductEntity());
			add("url", "https://iamge.com/image-03.jpg");
		}});
		
		Fixture.of(ProductImagesEntity.class).addTemplate("product-images-entity-test-04", new Rule() {{
			add("id", 4L);
			add("productId", new ProductEntity());
			add("url", "https://iamge.com/image-04.jpg");
		}});
	}

}
