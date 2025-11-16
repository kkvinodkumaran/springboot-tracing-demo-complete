package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {

  @Autowired
  private Tracer tracer;

  @GetMapping("/hello")
  public String hello() {
    Span span = tracer.spanBuilder("custom-span").startSpan();
    span.addEvent("processing-hello");
    try { Thread.sleep(50); } catch(Exception e){}
    span.end();
    return "Hello with tracing!";
  }
}
