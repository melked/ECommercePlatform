package com.melikedemirtas.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melikedemirtas.controller.ICustomerController;
import com.melikedemirtas.entities.Customer;
import com.melikedemirtas.services.ICustomerService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("rest/api/customer")
public class CustomerControllerImpl  implements ICustomerController{

	  @Autowired
	    private ICustomerService customerService;

	    @PostMapping(path = "/add")
	    @Override
	    public Customer AddCustomer(@RequestBody Customer customer) {
	        return customerService.AddCustomer(customer);
	    }

	    @GetMapping(path = "/{id}")
	    @Override
	    public Customer getCustomerById(@PathVariable Integer id) {
	        return customerService.getCustomerById(id);
	    }

	    @GetMapping(path = "/all")
	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }
	
	

}
