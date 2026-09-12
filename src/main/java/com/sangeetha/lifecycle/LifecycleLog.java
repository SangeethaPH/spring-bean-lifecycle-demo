package com.sangeetha.lifecycle;

import java.util.concurrent.atomic.AtomicInteger;

public final class LifecycleLog {
    private static final AtomicInteger SEQUENCE = new AtomicInteger();

    private LifecycleLog() {
    }

    public static void step(String phase, String message) {
        System.out.printf("%02d | %-22s | %s%n",
                SEQUENCE.incrementAndGet(), phase, message);
    }
}
