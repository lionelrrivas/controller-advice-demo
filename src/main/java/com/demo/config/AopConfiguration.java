package com.demo.config;

import com.demo.aop.advice.CustomPerformanceMonitorInterceptor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {
    
    @Pointcut(
      "execution(public com.demo.entity.Customer com.demo.service.CustomerService.findById(..)) || "
              + "execution(public com.demo.entity.Customer com.demo.repository.CustomerRepository.findById(..))"
    )
    public void customMonitor() { }
    
    @Bean
    public CustomPerformanceMonitorInterceptor customPerformanceMonitorInterceptor() {
        return new CustomPerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor myPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.demo.config.AopConfiguration.customMonitor()");
        return new DefaultPointcutAdvisor(pointcut, customPerformanceMonitorInterceptor());
    }

}
