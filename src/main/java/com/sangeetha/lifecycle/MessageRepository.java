package com.sangeetha.lifecycle;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    public MessageRepository() {
        LifecycleLog.step("CONSTRUCTOR", "MessageRepository created");
    }

    public String findMessage(String name) {
        return "Hello, " + name + " — your bean is ready!";
    }
}
