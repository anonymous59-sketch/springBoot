package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class BeforeAdvice {

	@Pointcut("execution(* com.example.demo..*Service.*(..))")
	public void  allpointcut() {}

	@After("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		//메서드명
		String methodName = jp.getSignature().getName();
		//methodName += ":" + jp.toLongString();
		//methodName += ":" + jp.toShortString();

		//인수(argument)
		Object[] args = jp.getArgs();
		Object arg1 =  (args != null && args.length>0 ? args[0] : "") ;
		log.info("[사전처리로그] beforeLog \t[" + methodName +"] [arg] " + arg1);
	}
    
}