package com.backend.westernunion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.westernunion.exceptionHandler.BusinessException;
import com.backend.westernunion.model.CustomerEntity;
import com.backend.westernunion.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<CustomerEntity> findAll() {
		return customerService.findAll();
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<Long> create(@RequestBody CustomerEntity customerEntity) throws BusinessException{
		Long id = customerService.create(customerEntity);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

}
