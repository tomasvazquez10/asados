# ---------- ETAPA 1: BUILD ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia todo el proyecto
COPY . .

# Compila el proyecto
RUN mvn clean package -DskipTests


# ---------- ETAPA 2: RUN ----------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia el jar generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto (Render usa variable PORT)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]