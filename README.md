# 🚀 Transferência Backend Challenge

API REST desenvolvida em Java com Spring Boot para simular transferências financeiras entre usuários, seguindo regras de negócio como validação de saldo e autorização externa.

---

# 🧠 Visão Geral

Este projeto simula um sistema de pagamentos onde:

* Usuários podem ser **Pessoa Física** ou **Pessoa Jurídica**
* Apenas **Pessoa Física pode enviar dinheiro**
* Transferências passam por uma **validação externa**
* O sistema garante **consistência transacional**

---

# 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```text
Controller → Service → Repository → Database
```

### 📌 Camadas

* **Controller** → expõe a API REST
* **Service** → regras de negócio
* **Repository** → acesso ao banco (JPA)
* **Database** → PostgreSQL + Flyway

---

# 🔄 Fluxo de Transferência

```text
1. Recebe requisição
2. Valida dados
3. Verifica tipo de usuário
4. Verifica saldo
5. Consulta serviço externo (autorizador)
6. Persiste transação
7. Retorna resposta
```

---

# 🧾 Exemplo de Fluxo

```text
Cliente → POST /transferencias
        → validações
        → autorização externa
        → salva no banco
        → resposta 200 OK
```

---

# 🗄️ Banco de Dados

## Criar banco

```sql
CREATE DATABASE transferencia_db;
```

## Criar usuário

```sql
CREATE USER transferencia_user WITH PASSWORD '123456';
```

## Permissões

```sql
GRANT ALL PRIVILEGES ON DATABASE transferencia_db TO transferencia_user;
GRANT ALL ON SCHEMA public TO transferencia_user;
```

---

# ⚙️ Configuração da Aplicação

## application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/transferencia_db
spring.datasource.username=transferencia_user
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true
```

---

# ▶️ Como rodar o projeto

```bash
mvn spring-boot:run
```

---

# 📡 Endpoints

## 🔹 Criar usuário

```http
POST /usuarios
```

## 🔹 Transferência

```http
POST /transferencias
```

---

# 📄 Swagger

Acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🧪 Exemplo de Requisição

```json
{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```

---

# 🧩 Regras de Negócio

* ❌ Pessoa Jurídica não pode enviar dinheiro
* ❌ Não pode transferir sem saldo
* ❌ Transferência precisa ser autorizada externamente

---

# 🔐 Segurança

Atualmente desabilitada para desenvolvimento.

Futuro:

* JWT
* Autenticação por token

---

# 🐳 Melhorias futuras

* Docker (app + banco)
* Integração com mensageria (Kafka/RabbitMQ)
* Observabilidade (logs + métricas)
* Testes automatizados
* CI/CD

---

# 📊 Estrutura do Projeto

```text
src
 ┣ controller
 ┣ service
 ┣ repository
 ┣ model
 ┣ dto
 ┗ config
```

---

# 📌 Tecnologias

* Java 17+
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Flyway
* Maven

---

# 🎯 Objetivo

Demonstrar domínio em:

* Backend Java
* Arquitetura de APIs
* Regras de negócio
* Boas práticas

---

# 👨‍💻 Autor

Roger Eduardo Freitas
