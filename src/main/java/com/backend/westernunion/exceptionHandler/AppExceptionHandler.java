package com.backend.westernunion.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleValidationException(Exception ex, WebRequest request) {
        logger.error("Ha ocurrido un error", ex);
        String errorMessageDesccription = ex.getLocalizedMessage();
        
        if(errorMessageDesccription == null) errorMessageDesccription = ex.toString();
        
        return new ResponseEntity<String>("Error en la lógica del negocio", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
