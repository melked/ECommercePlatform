package com.melikedemirtas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer extends BaseEntity{
	
	   @Column(name = "first_name", nullable = false, length = 40)
	    private String firstname;

	    @Column(name = "last_name", nullable = false, length = 40)
	    private String lastname;

	    @Column(name = "email", nullable = false, length = 40)
	    private String email;
	
}
