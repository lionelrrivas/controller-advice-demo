package com.demo.aop.advice;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

@Slf4j
public class CustomPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

    public CustomPerformanceMonitorInterceptor() {}
    
    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }
    
    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        String name = createInvocationTraceName(invocation);
        Instant start = Instant.now();
        try {
            return invocation.proceed();
        }
        finally {
            log.info(name + " execution lasted " + Duration.between(start, Instant.now()).toMillis() + " ms");
        }
    }
    
}
