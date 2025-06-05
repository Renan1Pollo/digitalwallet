
# 💳 Digital Wallet

[![Docker](https://img.shields.io/badge/docker-ready-blue?logo=docker)](https://www.docker.com/)
[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://www.oracle.com/java/)

> 🧠 Projeto desenvolvido para consolidar conhecimentos em **Arquitetura Hexagonal**, **DDD** e **Kafka**, utilizando **Java 21** com **Spring Boot** e **Kafka**.

---

## 📘 Sobre o Projeto

Este projeto é uma **carteira digital** desenvolvida em Java, com o principal objetivo de aplicar na prática os conhecimentos previamente adquiridos sobre arquitetura hexagonal, Domain-Driven Design (DDD) e Kafka.
Trata-se de um desafio de backend proposto pelo PicPay, chamado **'PicPay Simplificado'**, que já havia sido realizado anteriormente e agora foi refeito por mim, reestruturando-o em uma versão mais robusta e aprimorada.

---

## 🚀 Tecnologias Utilizadas

- ⚙️ [Spring Boot](https://spring.io/projects/spring-boot)
- 🧩 [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- 🔄 [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)
- 🐳 [Docker Compose](https://docs.docker.com/compose/)
- 🗃️ [H2 Database](https://www.h2database.com/html/main.html)

---

## 🧱 Arquitetura Hexagonal + DDD

O projeto foi estruturado seguindo os princípios da **Arquitetura Hexagonal** e **Domain-Driven Design (DDD)**:

---

## ✅ Funcionalidades

| Funcionalidade                       
|-------------------------------------------------|
| 💸 Efetuar transferência entre usuários 
| 🔁 Consultar transferências          
| 📢 Enviar notificação                
| 📊 Consultar carteiras               

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 21](https://www.oracle.com/java/)

---

## 🧪 Como Executar

```bash
# 1. Clonar o repositório
git clone https://github.com/Renan1Pollo/digitalwallet.git
cd digitalwallet

# 2. Subir os serviços Kafka com Docker Compose
docker-compose up

# 3. Executar a aplicação Spring Boot
# Acesse http://localhost:8080 para verificar a execução
```

---

## 📬 Contato

Desenvolvido com ❤️ por [Renan Pollo Benelli](https://github.com/Renan1Pollo)  
📧 renanpollodev18@gmail.com
