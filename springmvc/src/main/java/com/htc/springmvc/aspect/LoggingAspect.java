package com.htc.springmvc.aspect;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class LoggingAspect implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info(target.getClass().toString()+"-----"+method.getName()+"------"+" Completed ExecutionS");
		logger.info(" Return Value:" + returnValue.toString());
		logger.info("--------------------------------------------------------");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info("Calling - "+target.getClass().toString()+"----"+method.getName()+" Completed ExecutionS ");
		logger.info("------------------------------------");
		
	}
	 
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {

		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info(method.getName() + " throws exception");
		logger.error("Error :" + ex.toString());
		logger.info("-------------------------------------------------------------------");

	}

	
}
