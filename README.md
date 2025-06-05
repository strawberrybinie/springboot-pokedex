# Pokedex Spring Boot App

Aplicación de ejemplo con Spring Boot y MySQL usando Docker Compose.
Proyecto final de Ingeniería de Software [ICO]

## Requisitos

- Docker
- Docker Compose
- Git

## Cómo correr la app

```bash
git clone https://github.com/strawberrybinie/springboot-pokedex.git
cd springboot-pokedex
./mvnw clean package
docker-compose up --build
```

## Probar app
Una vez que se haya podido construir el compose correctamente se pude pobrar en web o en una terminal de comandos con curl.
La app estará disponible en: "http://localhost:8081"

