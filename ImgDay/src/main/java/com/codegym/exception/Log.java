package com.codegym.exception;

import com.mysql.cj.conf.PropertyDefinitions;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Log {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.ImgService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
        System.out.println("[CMS] co loi xay ra: "+ className);
        System.out.println("[CMS] co loi xay ra: "+ method);
        System.out.println("[CMS] co loi xay ra: "+ args);
        System.out.println("[CMS] co loi xay ra: "+e.getMessage());
        System.out.println("[CMS] time: "+java.time.LocalDateTime.now());
    }
}
