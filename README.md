# 🔵 Afazeres - Gerenciador de Tarefas

O **Afazeres** é uma aplicação web completa para a gestão de tarefas pessoais, focada em produtividade e organização.  
O projeto foi desenvolvido com uma arquitetura robusta no **Backend** e uma interface limpa e responsiva no **Frontend**.

---

## Funcionalidades

### Autenticação Completa
- Sistema de **Login e Registo** de utilizadores  
- Validações manuais no backend  

###  Tela de Tarefas
- Visualização em tempo real dos afazeres do utilizador logado  

###  CRUD de Tarefas
- Criar tarefas  
- Listar tarefas  
- Editar tarefas  
- Eliminar tarefas  
- Definição de diferentes níveis de prioridade  

###  Interface Dinâmica
- Carregamento dinâmico de escolaridades via API  
- Seleção visual de género (Radio Buttons estilizados)  
- Modal inteligente para criação e edição  
- Sistema de notificações personalizado  

---

##  Tecnologias Utilizadas

###  Backend
- **Java 21**
- **Spring Boot 4.0.2**
- **Spring JDBC Template** → Comunicação direta e otimizada com o banco de dados
- **MySQL** → Armazenamento persistente de dados
- Arquitetura em camadas:
  - Controller
  - Service
  - Repository
- Uso de **DTOs (Records)**

###  Frontend
- **HTML5 & CSS3 puros** (sem bibliotecas externas)
- **JavaScript Vanilla**
  - Lógica de SPA (Single Page Application)
- Design responsivo (Mobile & Desktop)

---

##  Requisitos Atendidos

- ✅ Entradas de texto, numéricas e de data  
- ✅ Uso de Radio Buttons e Checkboxes  
- ✅ Dropdown (Select) carregado dinamicamente via API  
- ✅ Validações de campos obrigatórios  
- ✅ Lógica de negócio implementada no Backend  

---

##  Autor

Desenvolvido por **[Nicolas Barbosa /https://github.com/nicolas-barbosa-pereira]**  

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/4jAV28kZ)
# Projeto Individual - Programação Web 🚀
Este repositório contém o projeto individual desenvolvido para a disciplina de Programação Web. O objetivo é aplicar os conceitos de integração entre Front-end (Vanilla) e Back-end (Spring Boot), focando na persistência de dados e validações.

## 📋 Sobre o Projeto
O tema deste projeto é livre, permitindo a continuidade ou adaptação da ideia trabalhada no primeiro semestre. A aplicação consiste em um sistema de cadastro funcional integrado a um banco de dados.

## 🛠️ Requisitos Técnicos

### Front-end
O foco é a utilização de tecnologias nativas para garantir o domínio da linguagem.

* **Formulário de Cadastro:** Deve conter, obrigatoriamente, os seguintes tipos de entrada:
  * Texto e Numérico.
  * Data.
  * Radio Buttons e Checkboxes.
  * Dropdown (Select): Os dados deste campo devem ser carregados dinamicamente via API (Back-end).

* **Validação:** Implementar lógica de validação de dados no lado do cliente antes do envio das requisições.

### Back-end
Desenvolvido utilizando Java com o ecossistema Spring.

* Endpoint `GET`: Criado para fornecer a lista de informações necessária para popular o dropdown do formulário.
* Endpoint `POST`: Responsável por receber os dados do formulário e realizar a persistência em uma tabela no banco de dados.
* Regras de Negócio & Status HTTP:
  * Validar os dados recebidos antes da inserção.
  * Retornar Status `201 (Created)` em caso de sucesso.
  * Retornar Status `400 (Bad Request)` caso os dados sejam inválidos.


### Dicas para a Implementação:

#### 💡 Dicas gerais

* **No Front-end:** Utilize a função `fetch()` para realizar as chamadas aos endpoints.
* **No Back-end:** Lembre-se de configurar o `@CrossOrigin` no seu Controller para permitir que o seu HTML (rodando em uma porta ou arquivo local) consiga acessar a API do Spring Boot sem bloqueios de segurança.

#### 💾 JDBC no Spring

Configure o application.properties
Antes de tudo, aponte para o seu banco de dados MySQL no arquivo de configuração:

```
spring.datasource.url=?
spring.datasource.username=?
spring.datasource.password=?
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

O Spring injeta automaticamente o JdbcTemplate, que simplifica o código JDBC padrão (evitando aquele monte de try-catch e connection.close()).

```java
@Autowired
private JdbcTemplate jdbcTemplate;
```

#### 💅 Front-end

- Para instruções sobre como executar o frontend, consulte o [README do Frontend](./frontend/README.md)


## ⚠️ Restrições e Regras
Para garantir a equidade e o foco nos fundamentos, as seguintes restrições se aplicam:

1. **Spring Boot:** Não é permitido adicionar bibliotecas externas/adicionais além das iniciais do projeto.
2. **Front-end:** É estritamente proibido o uso de frameworks (como React, Vue, Angular) ou bibliotecas (como jQuery, Bootstrap, Tailwind). Deve-se utilizar apenas HTML5, CSS3 e JavaScript Vanilla.
