package com.melikedemirtas.services;

import java.util.List;

import com.melikedemirtas.entities.Customer;

public interface ICustomerService {

	  Customer AddCustomer(Customer customer);

	  Customer getCustomerById(Integer id);

	  List<Customer> getAllCustomers();
 }
