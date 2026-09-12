package com.sangeetha.lifecycle;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListener {

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        LifecycleLog.step("CONTEXT EVENT", "ContextRefreshedEvent");
    }

    @EventListener
    public void onContextClosed(ContextClosedEvent event) {
        LifecycleLog.step("CONTEXT EVENT", "ContextClosedEvent");
    }
}
