package mx.personal.petstore.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
 
@Aspect
@Component
public class LoggingAspect 
{   
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
 
    //AOP expression for which methods shall be intercepted
    @Around("execution(* mx.personal.petstore.service..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
         
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
         
        final StopWatch stopWatch = new StopWatch();
         
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
 
        //Log method execution time
        LOGGER.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");       
        return result;
    }
    
    @Before("execution(* mx.personal.petstore.service..*(..)))")
    public void before(JoinPoint joinPoint) throws Throwable  {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] pNames = methodSignature.getParameterNames();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        Object[] lArgs = joinPoint.getArgs();
        String end ="";
        int i =0;
        for (Object object : lArgs) {
        	if (i!=0) {
				end += ", ";
			}
			end += pNames[i]+": "+object.toString();
			i++;
		}        
        LOGGER.info(className + "." + methodName + " :: " + end);       

    }
    

    @SuppressWarnings("unchecked")
	@AfterReturning(
    		pointcut="execution(* mx.personal.petstore.service..*(..)))",
    		returning="objectReturn")
    public void after(JoinPoint joinPoint, Object objectReturn) throws Throwable  {
 
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();        
        if (methodSignature.getReturnType().toString().equals(
        		"interface org.springframework.data.domain.Page")) {
        	objectReturn = ((PageImpl<Object>) objectReturn).getContent();
		}
        LOGGER.info(className + "." + methodName + " :: " + objectReturn );       

    }
    
    
    @AfterThrowing(
    	    pointcut="execution(* mx.personal.petstore.service..*(..)))",
    	    throwing="exec")
    public void catchAllSQLSyntaxErrors(Exception exec) throws Throwable {
    	LOGGER.info(exec.getClass() + " XX " + exec.getMessage() );
    }
    
}