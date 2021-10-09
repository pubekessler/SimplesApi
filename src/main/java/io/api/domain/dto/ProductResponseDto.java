package io.api.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class ProductResponseDto implements Serializable {

      /**
	 * 
	 */
	private static final long serialVersionUID = -1573556640959545232L;
	private Long id;
	
	private String name;
	
	private String description;
	@Positive @Digits(integer=10, fraction=2)
	private BigDecimal price;
   

}
