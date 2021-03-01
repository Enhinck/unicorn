package com.enhinck.demoservice.config;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/20/21 3:16 PM
 */
@Aspect
//@Component
@Slf4j
public class SeataTransactionalAspect {

    @Around("@annotation(io.seata.spring.annotation.GlobalTransactional)")
    public Object checkToken(ProceedingJoinPoint pro) throws Throwable {
        MethodSignature signature = (MethodSignature)pro.getSignature();
        Method method = signature.getMethod();
        log.info("拦截到需要分布式事务的方法," + method.getName());
        // 此处可用redis或者定时任务来获取一个key判断是否需要关闭分布式事务
        GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
        tx.begin();
        log.info("创建分布式事务完毕" + tx.getXid());
        Object proceed = pro.proceed();
        return proceed;
    }


//    @Before("execution(* com.enhinck.demoservice.service.*.*(..))")
//    public void before(JoinPoint joinPoint) throws TransactionException {
//        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
//        Method method = signature.getMethod();
//        if(method.isAnnotationPresent(GlobalTransactional.class)) {
//            log.info("拦截到需要分布式事务的方法," + method.getName());
//            // 此处可用redis或者定时任务来获取一个key判断是否需要关闭分布式事务
//            GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
//            tx.begin();
//            log.info("创建分布式事务完毕" + tx.getXid());
//        }
//
//
//    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.enhinck.demoservice.service.*.*(..))")
    public void doRecoveryActions(Throwable e) throws TransactionException {
        log.info("方法执行异常:{}", e.getMessage());
        if (!StringUtils.isBlank(RootContext.getXID())) {
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
        }
    }

}
