package com.revature.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.revature.services.*.*(..))")
	public void logServiceMethods(JoinPoint joinPoint) {
		log.warn(joinPoint.getTarget() + " invoked ..................................." + joinPoint.getSignature() + " with param " + joinPoint.getArgs());
	}
	
//	@AfterReturning(pointcut="execution(* findBySuperheroName(..))", returning="returnedObject")
//	public void logSearchBySupName(JoinPoint joinPoint, Object returnedObject) {
//		log.warn(joinPoint.getTarget() + " invoked " + joinPoint.getSignature() + " and returned "+returnedObject.toString());
//	}
//	
//	@AfterThrowing(pointcut="execution(* findBySupName(String))", throwing="exception")
//	public void logSupNameException(JoinPoint joinPoint, Exception exception) {
//		log.warn(joinPoint.getTarget() + " invoked " + joinPoint.getSignature() + " and threw " + exception.getMessage());
//	}
//	
	

}
