# Usar una imagen oficial de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo .jar desde el directorio target al contenedor
COPY target/*.jar franquicias-api.jar

# Exponer el puerto en el que la aplicación va a estar escuchando (ajustar si es necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "franquicias-api.jar"]
