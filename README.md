# Spring ApplicationContext and Bean Lifecycle Demo

A focused Maven project that makes the Spring container and bean lifecycle visible through numbered console messages.

## What it demonstrates

- Creating and closing an `AnnotationConfigApplicationContext`
- Java configuration with `@Configuration`, `@ComponentScan`, and `@Bean`
- Constructor dependency injection
- `BeanNameAware` and `ApplicationContextAware`
- `BeanPostProcessor` before/after initialization hooks
- `@PostConstruct`, `InitializingBean`, and a custom init method
- `ContextRefreshedEvent` and `ContextClosedEvent`
- `@PreDestroy`, `DisposableBean`, and a custom destroy method

## Requirements

- JDK 17+
- Maven 3.9+

## Run

```bash
mvn clean compile exec:java
```

The numbered output exposes the order in which Spring invokes lifecycle callbacks.

## Lifecycle order shown

1. Create the application context.
2. Instantiate dependencies and the bean.
3. Invoke `Aware` callbacks.
4. Run the post-processor before initialization.
5. Invoke `@PostConstruct`.
6. Invoke `InitializingBean.afterPropertiesSet()`.
7. Invoke the configured custom init method.
8. Run the post-processor after initialization.
9. Publish `ContextRefreshedEvent`.
10. Use the fully initialized bean.
11. Close the context and publish `ContextClosedEvent`.
12. Invoke `@PreDestroy`, `DisposableBean.destroy()`, and the custom destroy method.

> In production code, prefer `@PostConstruct` and `@PreDestroy` when lifecycle callbacks are genuinely needed. Implementing Spring-specific lifecycle interfaces couples the class to Spring; this project includes every mechanism for demonstration.
