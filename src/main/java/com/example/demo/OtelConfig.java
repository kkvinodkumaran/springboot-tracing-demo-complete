package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.GlobalOpenTelemetry;

@Configuration
public class OtelConfig {
  @Bean
  public Tracer tracer() {
    return GlobalOpenTelemetry.getTracer("springboot-tracing-demo");
  }
}
