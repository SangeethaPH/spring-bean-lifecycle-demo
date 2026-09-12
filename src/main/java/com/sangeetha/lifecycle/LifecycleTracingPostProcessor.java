package com.sangeetha.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleTracingPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof ReportService) {
            LifecycleLog.step("BEAN POST-PROCESSOR", "Before initialization: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof ReportService) {
            LifecycleLog.step("BEAN POST-PROCESSOR", "After initialization: " + beanName);
        }
        return bean;
    }
}
