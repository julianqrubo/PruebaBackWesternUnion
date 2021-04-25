package com.backend.westernunion.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.westernunion.exceptionHandler.BusinessException;
import com.backend.westernunion.model.CustomerEntity;
import com.backend.westernunion.repository.CustomerRepository;
import com.backend.westernunion.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

//	Esta clase implementa los métodos establecidos en la interfaz CustomerService
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Long create(CustomerEntity customerEntity) {
		final String _name = customerEntity.getName();
		final int _years = customerEntity.getYears();
		final String _email = customerEntity.getEmail();
		final boolean validateEmail = com.backend.westernunion.utils.Utils.validateEmail(_email);
		validateFields(_name, _years, validateEmail);
		customerEntity.setName(_name.toUpperCase().trim());
		customerEntity.setEmail(_email.toUpperCase().trim());
		customerEntity = customerRepository.save(customerEntity);
		return customerEntity.getId();
	}

	private void validateFields(final String _name, final int _years, final boolean validateEmail) {
		if (_name.length() == 0) {
			System.err.println("El nombre es requerido");
			throw new BusinessException("El nombre es requerido");
		} else if (_name.length() > 40) {
			System.err.println("La longitud del nombre debe ser máximo de 40 caracteres");
			throw new BusinessException("La longitud del nombre debe ser máximo de 40 caracteres");
		} else if (_years <= 0) {
			System.err.println("La edad es inválida");
			throw new BusinessException("La edad es inválida");
		} else if (_years >= 100) {
			System.err.println("La edad máxima debe ser de 99 años");
			throw new BusinessException("La edad máxima debe ser de 99 años");
		} else if (_years < 18) {
			System.err.println("No cumple con la mayoría de edad");
			throw new BusinessException("No cumple con la mayoría de edad");
		} else if (!validateEmail) {
			System.err.println("La dirección de correo no es válida");
			throw new BusinessException("La dirección de correo no es válida");
		}
	}

}
