package com.br.productapi.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.productapi.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Query("SELECT DISTINCT p "
			+ "FROM ProductEntity p "
			+ "INNER JOIN p.images "
			+ "WHERE p.name LIKE %?1% "
			+ "OR p.category LIKE %?1% "
			+ "OR p.size LIKE %?1% ")
	public Optional<List<ProductEntity>> getProductsByText(String text, Pageable pageable);
	
	@Query("SELECT DISTINCT p FROM ProductEntity p INNER JOIN p.images ")
	public Optional<List<ProductEntity>> getAllProducts(Pageable pageable);
}
