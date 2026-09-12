package com.sangeetha.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleDemoApplication {

    public static void main(String[] args) {
        LifecycleLog.step("MAIN", "Creating ApplicationContext");

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            LifecycleLog.step("MAIN", "Context is ready; requesting ReportService");
            ReportService service = context.getBean(ReportService.class);
            service.generateReport("Spring learner");

            LifecycleLog.step("MAIN", "Bean count = " + context.getBeanDefinitionCount());
            LifecycleLog.step("MAIN", "Leaving try block; context.close() runs automatically");
        }

        LifecycleLog.step("MAIN", "Application finished");
    }
}
