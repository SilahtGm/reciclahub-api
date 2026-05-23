# =========================
# Stage 1 - Build
# =========================
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /build

# Copia wrappers e arquivos do Maven primeiro para aproveitar cache de dependências
COPY mvnw mvnw.cmd pom.xml ./
COPY .mvn ./.mvn

RUN chmod +x mvnw && ./mvnw -B -q dependency:go-offline

# Copia o código-fonte e empacota
COPY src ./src
RUN ./mvnw -B -q clean package -DskipTests

# =========================
# Stage 2 - Runtime
# =========================
FROM eclipse-temurin:21-jre-alpine

# Cria um usuário não-root por segurança
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

RUN chown -R spring:spring /app
USER spring

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
