package com.melikedemirtas.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melikedemirtas.entities.Customer;
import com.melikedemirtas.repository.CustomerRepository;
import com.melikedemirtas.services.ICustomerService;


@Service
public class CustomerServiceImpl implements ICustomerService{
	  @Autowired
	    private CustomerRepository customerRepository;

	    @Override
	    public Customer AddCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @Override
	    public Customer getCustomerById(Integer id) {
	        return customerRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
	    }

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }
}
