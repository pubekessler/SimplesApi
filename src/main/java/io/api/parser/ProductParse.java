package io.api.parser;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.api.domain.Product;
import io.api.domain.dto.ProductRequestDto;
import io.api.domain.dto.ProductResponseDto;

@Component
public class ProductParse {

	public Product RequestDtoToEntity(ProductRequestDto dto) {
		return new ModelMapper().map(dto, Product.class);

	}

	public ProductResponseDto entityToResponseDto(Product entity) {
		return new ModelMapper().map(entity, ProductResponseDto.class);

	}
	
	public List<ProductResponseDto> entityToResponseDto(List<Product> entitys) {
		return entitys.stream().map(this::entityToResponseDto).collect(Collectors.toList());
		

	}

}
