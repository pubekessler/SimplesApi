package io.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import io.api.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("from Product where (:q is null or (name = :q or description = :q)) and (:min_price is null or price >= : min_price) and (:max_price is null or price <= :max_price)")
	List<Product> findSearch(String q, BigDecimal min_price, BigDecimal max_price);

}
