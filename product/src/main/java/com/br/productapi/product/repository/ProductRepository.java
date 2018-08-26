package com.br.productapi.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.productapi.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p "
			+ "FROM Product p "
			+ "INNER JOIN ProductImages pi "
			+ "WHERE p.name LIKE CONCAT('%', :text,'%') "
			+ "OR p.category LIKE CONCAT('%', :text, '%')")
	public List<Product> getProductsByText(@Param("text")String text, Pageable pageable);
}
