# 📝 Proposal Management API

Este é um projeto de caso de estudo focado na criação de uma API RESTful para o gerenciamento de propostas (Proposals) entre Influenciadores e Marcas (Brands).

A aplicação foi construída com boas práticas de engenharia de software, utilizando **Java, Spring Boot e Spring Security**, além de conceitos de separação por Casos de Uso (Use Cases) para manter o domínio da aplicação isolado e organizado.

## 🚀 Tecnologias Utilizadas

* **Java 26**
* **Spring Boot 4.1.1 (Web, Security, Data JPA)
* **Spring Security** (Autenticação baseada em sessão com filtros customizados)
* **MySQL** (Banco de dados relacional)
* **Docker & Docker Compose** (Para subir o banco de dados facilmente)
* **Lombok** (Para reduzir a verbosidade do código)

## 🏗️ Arquitetura e Padrões

O projeto foge do padrão tradicional MVC básico e busca uma estrutura mais limpa e focada no domínio:
- **Domain-Driven Design (DDD) básico**: Uso de Value Objects (`OwnerId`, `ProposalId`) para garantir a integridade dos dados e expressividade do domínio.
- **Use Cases**: A regra de negócio não fica nos Controllers, mas sim em classes de Caso de Uso (`CreateProposalUseCase`, `ListProposalUseCase`), facilitando testes e manutenção.
- **Records**: Uso intensivo de `records` do Java moderno para DTOs, Inputs e Outputs (`ProposalOutput`, `ProposalResponse`), garantindo imutabilidade na transferência de dados.

## 🔐 Autenticação e Segurança

A API é protegida utilizando o Spring Security. Existem perfis de acesso diferentes:
* `ROLE_INFLUENCER`: Pode criar e listar as próprias propostas.
* `ROLE_BRAND`: (Em desenvolvimento) Permissões focadas nas marcas que receberão as propostas.

O login é feito através de um filtro customizado (`restUsernamePasswordAuthenticationFilter`) que intercepta chamadas no endpoint `/api/auth/login`.

## ⚙️ Como executar o projeto

### 1. Subir o Banco de Dados
A aplicação depende de um banco de dados MySQL. Para facilitar, o projeto já vem com um arquivo `compose.yml`.
Basta abrir o terminal na raiz do projeto e rodar:
```bash
docker compose up -d
```
Isso iniciará um banco de dados MySQL na porta `3307`.

### 2. Rodar a Aplicação
Com o banco rodando, inicie a aplicação Spring Boot pela sua IDE ou via Gradle:
```bash
./gradlew bootRun
```

### 3. Testando a API
Na primeira execução, o banco de dados é populado automaticamente com os seguintes usuários para teste:
- **Usuário:** `fitness_vibe` | **Senha:** `password` (Role: Influencer)
- **Usuário:** `tech_guru` | **Senha:** `password` (Role: Influencer)
- **Usuário:** `logistics` | **Senha:** `password` (Role: Brand)

#### 🔸 Passo A: Fazer Login
```http
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "fitness_vibe",
  "password": "password"
}
```

#### 🔸 Passo B: Criar Proposta
```http
POST http://localhost:8080/proposals
Content-Type: application/json

{
  "title": "Minha primeira proposta de patrocínio",
  "description": "Detalhes sobre a campanha..."
}
```

#### 🔸 Passo C: Listar Propostas
```http
GET http://localhost:8080/proposals
```

---
*Este projeto foi desenvolvido como um caso de estudo para aprofundamento em arquitetura de software, Spring Security e boas práticas com Java.*
