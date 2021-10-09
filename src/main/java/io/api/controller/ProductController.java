package io.api.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.api.domain.dto.ProductRequestDto;
import io.api.domain.dto.ProductResponseDto;
import io.api.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductResponseDto> createProducts(@RequestBody @NotNull @Valid ProductRequestDto dto) {

		return new ResponseEntity<>(productService.create(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProducts(@RequestBody @NotNull @Valid ProductRequestDto dto,
			@PathVariable Long id) {

		return new ResponseEntity<>(productService.update(dto, id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getProducts(@PathVariable Long id) {

		return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {

		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ProductResponseDto>> searchProducts(@RequestParam(required = false) String q, @RequestParam(required = false) BigDecimal min_price, @RequestParam(required = false) BigDecimal max_price) {

		return new ResponseEntity<>(productService.search(q,min_price, max_price), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteProducts(@PathVariable Long id) {

		return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
	}

	
	
}