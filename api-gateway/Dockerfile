# Используем образ Maven с OpenJDK 17 для сборки приложения
FROM maven:3.8.3-openjdk-17 AS build

# Указываем рабочую директорию
WORKDIR /api-gateway

# Копируем файл зависимостей
COPY pom.xml ./

# Копируем зависимости
RUN mvn dependency:go-offline

# Копируем весь проект
COPY . .

# Собираем приложение
RUN mvn clean package -DskipTests

# Используем более легкий образ для запуска приложения
FROM maven:3.8.3-openjdk-17

# Указываем рабочую директорию
WORKDIR /api-gateway

# Копируем собранный JAR файл из предыдущего этапа
COPY --from=build /api-gateway/target/*.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Открываем порт, если необходимо
EXPOSE 8080
