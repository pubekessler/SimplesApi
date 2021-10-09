package io.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8304265497934392981L;
	@Id
	@GeneratedValue
    private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
   

  

}
