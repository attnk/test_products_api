package com.br.productapi.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.productapi.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Query("SELECT p "
			+ "FROM Product p "
			+ "INNER JOIN ProductImages pi "
			+ "WHERE p.name LIKE CONCAT('%', :text,'%') "
			+ "OR p.category LIKE CONCAT('%', :text, '%')")
	public Optional<List<ProductEntity>> getProductsByText(@Param("text")String text, Pageable pageable);
}
