package com.backend.westernunion.service;

import java.util.List;

import com.backend.westernunion.exceptionHandler.BusinessException;
import com.backend.westernunion.model.CustomerEntity;

public interface CustomerService {

//	Esta interfaz es como un contrato donde defino los métodos que se van a implementar.

	List<CustomerEntity> findAll();

	Long create(CustomerEntity entity) throws BusinessException;
}
