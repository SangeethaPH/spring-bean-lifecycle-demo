package com.sangeetha.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ReportService implements BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private final MessageRepository messageRepository;

    public ReportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        LifecycleLog.step("CONSTRUCTOR", "ReportService created; dependency injected");
    }

    @Override
    public void setBeanName(String name) {
        LifecycleLog.step("AWARE CALLBACK", "BeanNameAware received: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        LifecycleLog.step("AWARE CALLBACK", "ApplicationContextAware received context");
    }

    @PostConstruct
    public void postConstruct() {
        LifecycleLog.step("INITIALIZATION", "@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        LifecycleLog.step("INITIALIZATION", "InitializingBean.afterPropertiesSet()");
    }

    public void customInit() {
        LifecycleLog.step("INITIALIZATION", "Custom init-method");
    }

    public void generateReport(String name) {
        LifecycleLog.step("BUSINESS METHOD", messageRepository.findMessage(name));
    }

    @PreDestroy
    public void preDestroy() {
        LifecycleLog.step("DESTRUCTION", "@PreDestroy");
    }

    @Override
    public void destroy() {
        LifecycleLog.step("DESTRUCTION", "DisposableBean.destroy()");
    }

    public void customDestroy() {
        LifecycleLog.step("DESTRUCTION", "Custom destroy-method");
    }
}
