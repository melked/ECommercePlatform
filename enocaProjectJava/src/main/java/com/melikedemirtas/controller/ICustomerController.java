package com.melikedemirtas.controller;

import com.melikedemirtas.entities.Customer;
import java.util.List;
//import org.springframework.web.bind.annotation.PathVariable;


public interface ICustomerController {

	public Customer AddCustomer(Customer customer);
	Customer getCustomerById(Integer id);
	List<Customer> getAllCustomers();
	
}