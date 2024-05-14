# 🛒 E-commerce Project Back-End 

Este é um projeto de e-commerce desenvolvido em Java utilizando Spring Framework, JPA, Lombok, H2 Database, DevTools e Bcrypt. O projeto permite que usuários gerenciem endereços, adicionem produtos ao carrinho de compras e administradores gerenciem produtos.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para simplificar a criação de aplicativos.
- **Spring Data JPA**: Simplifica a interação com bancos de dados.
- **Lombok**: Biblioteca para reduzir o código boilerplate.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Spring Boot DevTools**: Ferramentas para facilitar o desenvolvimento.
- **Spring Security**: Para autenticação e segurança.
- **Bcrypt**: Para criptografia de senhas.

## Funcionalidades

- **Usuários**:
    - Cadastro e login.
    - Gestão de múltiplos endereços.
    - Realizar Pedido.

- **Usuários Administradores**:
    - Gestão de produtos (criar, atualizar, deletar).

## Como Executar o Projeto

### Pré-requisitos

- Java JDK 17 ou superior
- Maven

### Passos para execução

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio
    ```

2. **Compile e execute o projeto**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. **Acesse a aplicação**:
    - Frontend: `http://localhost:8080`
    - H2 Console: `http://localhost:8080/h2-console`

## Configurações

### application.properties

```properties
# Porta do servidor
server.port=8080

# Configuração do H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

# Configuração do Spring JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
