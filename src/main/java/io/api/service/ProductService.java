package io.api.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import io.api.domain.Product;
import io.api.domain.dto.ProductRequestDto;
import io.api.domain.dto.ProductResponseDto;
import io.api.exception.NotFoundException;
import io.api.parser.ProductParse;
import io.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	private final ProductParse productParse;

	public Product findByDriverID(Long id) {
		return productRepository.findById(id).get();
	}

	public ProductResponseDto create(@NotNull @Valid ProductRequestDto dto) {
		Product newProduct = productParse.RequestDtoToEntity(dto);

		productRepository.save(newProduct);

		return productParse.entityToResponseDto(newProduct);
	}

	public ProductResponseDto update(@NotNull @Valid ProductRequestDto dto, Long id) {

		Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());

		productRepository.save(product);

		return productParse.entityToResponseDto(product);
	}

	public ProductResponseDto get(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
		return productParse.entityToResponseDto(product);
	}

	public List<ProductResponseDto> getAll() {
		List<Product> lista = productRepository.findAll();
		return productParse.entityToResponseDto(lista);
	}

	public List<ProductResponseDto> search(String q, BigDecimal min_price, BigDecimal max_price) {
	
		List<Product> lista =productRepository.findSearch(q, min_price, max_price);
		
		return productParse.entityToResponseDto(lista);
	}

	public Long delete(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
		productRepository.delete(product);
		return id;
	}

}
