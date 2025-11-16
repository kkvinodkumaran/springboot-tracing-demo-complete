# Distributed Tracing Demo (Spring Boot + OTEL + Jaeger)

This example demonstrates how to enable OpenTelemetry tracing in a Spring Boot application and export spans to Jaeger, using Docker Compose to run the full environment locally.

## ✔ Features

- Spring Boot 3 application
- OpenTelemetry Tracer (manual instrumentation)
- Jaeger tracing backend
- Docker Compose integration
- `/hello` endpoint generates spans
- Full end-to-end trace visibility

## 📦 Project Structure

```
.
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── src/main/java/com/example/demo
    ├── DemoApplication.java
    ├── HelloController.java
    └── OtelConfig.java
```

## 🐳 Run with Docker Compose

### 1️⃣ Build Docker Image
```bash
docker build -t springboot-tracing-demo .
```

### 2️⃣ Start Application + Jaeger
```bash
docker compose up -d
```

### 3️⃣ Call the Endpoint
```
http://localhost:8080/hello
```

### 4️⃣ Open Jaeger UI
```
http://localhost:16686
```

Search for service: **springboot-tracing-demo**

You will see the custom-span.

## 🧠 How Tracing Works (OTEL)

1. Spring Boot creates a span
2. OTEL SDK stores it in an in-memory buffer
3. OTEL exporter pushes it to Jaeger Collector (4318)
4. Jaeger stores it in memory
5. Jaeger UI displays it

## 🆚 OTEL vs Prometheus (Important)

| Feature | OpenTelemetry | Prometheus |
|---------|---------------|------------|
| **Use** | Distributed tracing | Metrics |
| **Model** | Push (App → Jaeger) | Pull (Prometheus → App) |
| **Data** | Spans & traces | CPU, memory, latency |
| **Storage** | Jaeger | Prometheus TSDB |
| **UI** | Jaeger UI | Grafana |

## 📌 Requirements

- JDK 17
- Maven
- Docker & Docker Compose

## 📜 License

Open-source. Feel free to modify.