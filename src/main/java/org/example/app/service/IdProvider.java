package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j2
public class IdProvider implements InitializingBean, DisposableBean,
        BeanPostProcessor {

    public String providerId(Book book) {
        return this.hashCode() + "_" + book.hashCode();
    }

    private void initIdProvider() {
        log.info("init Provider");
    }

    private void destroyIdProvider() {
        log.info("destroy Provider");
    }

    private void defaultInit() {
        log.info("default INIT in Provider");
    }

    private void defaultDestroy() {
        log.info("destroy INIT in Provider");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean destroy invoked");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("provider afterPropertiesSet invoked");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        log.info("postProcessBeforeInitialization invoke by bean " + beanName);
//        return BeanPostProcessor.super
//                .postProcessBeforeInitialization(bean, beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        log.info("postProcessAfterInitialization invoke by bean " + beanName);
//        return BeanPostProcessor.super
//                .postProcessAfterInitialization(bean, beanName);
        return null;
    }

    @PostConstruct
    public void postConstructIdProvider() {
        log.info("PostConstruct annotated method called");
    }

    @PreDestroy
    public void preDestroyIdProvider() {
        log.info("PreDestroy annotated method called");
    }


}
