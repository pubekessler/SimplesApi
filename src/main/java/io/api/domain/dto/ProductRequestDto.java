package io.api.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class ProductRequestDto implements Serializable {

      /**
	 * 
	 */
	private static final long serialVersionUID = -1573556640959545232L;
	
	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty
	private String description;
	@NotNull @Positive @Digits(integer=10, fraction=2)
	private BigDecimal price;
   

}
