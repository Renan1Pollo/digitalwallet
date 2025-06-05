# 💳 Digital Wallet

[![Docker](https://img.shields.io/badge/docker-ready-blue?logo=docker)](https://www.docker.com/)

Este projeto é uma carteira digital desenvolvida em Java, com o principal objetivo de aplicar na prática os conhecimentos previamente adquiridos sobre arquitetura hexagonal, Domain-Driven Design (DDD) e Kafka. Trata-se de um desafio de backend proposto pelo PicPay, chamado 'PicPay Simplificado', que já havia sido realizado anteriormente e que agora refiz, reestruturando-o em uma versão mais robusta e aprimorada.

## 🚀 Tecnologias Utilizadas
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)
- [Docker Compose](https://docs.docker.com/compose/)
- [H2](https://www.h2database.com/html/main.html)

## 🧱 Arquitetura Hexagonal + DDD

O projeto segue princípios de arquitetura hexagonal com DDD (Domain-Driven Design).

## ✅ Funcionalidades

- ✅ Efetuar transferência entre usuários
- 🔁 Consultar transferências
- ⭐ Enviar notificação
- 📊 Consultar carteiras


## ⚙️ Pré-requisitos

- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
- [Java 21](https://www.oracle.com/java/)

---

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/Renan1Pollo/digitalwallet.git
```
- Executar o Kafka:
```
docker-compose up
```
- Executar a aplicação Spring Boot
- Acessar aplicação em `http://localhost:8080`.



## 📬 Contato

Desenvolvido por [Renan Pollo Benelli](https://github.com/Renan1Pollo)
