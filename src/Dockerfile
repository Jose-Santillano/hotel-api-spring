# Etapa de construcción
FROM maven:3.8.5-openjdk-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y otros archivos necesarios
COPY pom.xml .

# Descarga las dependencias sin construir la aplicación
RUN mvn dependency:go-offline -B

# Copia todo el código fuente al contenedor
COPY src ./src

# Compila la aplicación y empaqueta en un JAR
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado desde la etapa de construcción
COPY --from=build /app/target/hotel-0.0.1-SNAPSHOT.jar ./hotel.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "hotel.jar"]
