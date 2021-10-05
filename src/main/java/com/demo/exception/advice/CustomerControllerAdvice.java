package com.demo.exception.advice;

import javax.servlet.http.HttpServletRequest;
import com.demo.entity.CustomerError;
import com.demo.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerControllerAdvice {
    
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomerError handleNotFound(HttpServletRequest request, Exception exception) {
        return new CustomerError(exception.getLocalizedMessage(), request.getRequestURI());
    }
    
}
