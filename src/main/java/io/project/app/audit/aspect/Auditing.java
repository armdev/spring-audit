package io.project.app.audit.aspect;

import java.util.Arrays;
import java.util.Objects;
import javax.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.server.ServerHttpRequest;

@Aspect
@Slf4j
public class Auditing {

    @Before("execution(* io.project.app.audit.resources.HeroResource.find(..))")
    public void validate() {
        log.info("Logging before");
    }

    @AfterReturning("execution(* io.project.app.audit.resources.HeroResource.find(..))")
    public void validateAfter() {
        log.info("Logging after returning");
    }

    // @Before("execution(* io.project.app..*.*(.., org.springframework.http.server.reactive.ServerHttpRequest+, ..)) ")
    // @Before("execution(* io.project.app.audit.resources.HeroResource.find(..))")
    public void validateBefore(JoinPoint jp) {
        log.info("Validate Before request ");
         log.info("jp.getArgs() " +jp.getArgs());
        ServerHttpRequest request
                = Arrays
                        .stream(jp.getArgs())
                        .filter(Objects::nonNull)
                        .filter(arg -> ServerHttpRequest.class.isAssignableFrom(arg.getClass()))
                        .map(ServerHttpRequest.class::cast)
                        .findFirst().get();
        log.info("Find token started ");
        if (request.getHeaders().get("token") != null) {
            String token = request.getHeaders().get("token").get(0);
            log.info("FOUND TOKEN " + token);
        }

    }

    //@Before("execution(* io.project..*.*(.., javax.servlet.ServletRequest+, ..)) ")
    //    @Before("execution(* io.project.app.audit.resources.HeroResource.find(..))")
    public void wait(JoinPoint jp) throws Throwable {
        log.info("wait " + "started");
        ServletRequest request
                = Arrays
                        .stream(jp.getArgs())
                        .filter(Objects::nonNull)
                        .filter(arg -> ServletRequest.class.isAssignableFrom(arg.getClass()))
                        .map(ServletRequest.class::cast)
                        .findFirst()
                        .get();
        String ip = request.getRemoteAddr();
        log.info("ip " + ip);

    }

    //https://stackoverflow.com/questions/28975025/advise-controller-method-before-valid-annotation-is-handled
    /// https://stackoverflow.com/questions/39271035/how-do-i-get-my-spring-aspects-to-execute-before-valid-validated-annotation-on
}
