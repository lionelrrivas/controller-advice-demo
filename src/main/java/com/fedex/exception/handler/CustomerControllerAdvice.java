package com.fedex.exception.handler;

import javax.servlet.http.HttpServletRequest;
import com.fedex.entity.CustomerError;
import com.fedex.exception.CustomerNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomerControllerAdvice {
    
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseBody
    public CustomerError handleNotFound(HttpServletRequest request, Exception exception) {
        return new CustomerError(exception.getLocalizedMessage(), request.getRequestURI());
    }
    
}
