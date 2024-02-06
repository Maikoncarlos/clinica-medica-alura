# Objetivos:
- O objetivo neste projeto é usarmos o Spring Boot para desenvolvermos uma API Rest, com algumas funcionalidades. A ideia é desenvolver um CRUD, sendo as quatro operações fundamentais das aplicações: cadastro, listagem, atualização e exclusão de informações.

-  Aplicar validações das informações que chegam na nossa API, usando o Bean Validation. Depois, vamos utilizar o conceito de paginação e ordenação das informações que a nossa API vai devolver.
-  Também iremos fazer o Tratamento de Excessões para que cada erro tenha seu status HTTP seguindo as boas práticas, bem como a padronização das mensagens de erros.
-  Funciona o processo de autenticação e autorização em uma API Rest;
-  Processo de autenticação na API Rest, de maneira Stateless, utilizando as classes e configurações do Spring Security, e guardando a informação de senha como hashing utilizando o ByCrypt.
-  Injetar uma propriedade do arquivo application.properties em uma classe gerenciada pelo Spring, utilizando a anotação @Value, para que não tenha informações sensível de forma explicita dentro do projeto;
-  Devolver um token JWT gerado na API quando um usuário se autenticar nela.

# Tecnologias:
    Spring Boot 3
    Java 17
    Lombok
    H2/MySQL/ Flyway
    Hibernate
    Maven
    Postman
    DTO (Data Transfer Object), via Java Records
    MapStruct
    Spring Data JPA
    Spring Security
    Token com Auth0 JWT

Faremos tudo isso usando algumas tecnologias, como Spring Boot 3, sendo a última versão disponibilizada pelo framework. Usaremos, também, o Java 17 sendo a última versão LTS (Long-term support, em português "Suporte de longo prazo") que possui maior tempo de suporte disponível para o Java.

Aprenderemos a usar alguns recursos das últimas versões do Java para deixarmos o nosso código mais simples. Utilizaremos em conjunto com o projeto o Lombok, responsável por fazer a geração de códigos repetitivos, como getters, setters, toString, entre outros. Tudo via anotações para o código ficar menos verboso.

Usaremos o banco de dados MySQL para armazenar as informações da API e junto com ele utilizaremos a biblioteca Flyway. Isso para termos o controle do histórico de evolução do banco de dados, um conceito que chamamos de Migration.

A camada de persistência da nossa aplicação será feita com a JPA (Java Persistence API), com o Hibernate como implementação dessa especificação e usando os módulos do Spring Boot, para tornar esse processo o mais simples possível.

Usaremos o Maven para gerenciar as dependências do projeto, e também para gerar o build da nossa aplicação. Por último, como focaremos na API Rest (apenas no Back-end), não teremos interface gráfica, como páginas HTML e nem Front-end e aplicativo mobile.

Mas para testarmos a API, usaremos o Postman, sendo uma ferramenta usada para testes em API. Com ela, conseguimos simular a requisição para a API e verificar se as funcionalidades implementadas estão funcionando.


# Qual é o nosso projeto?

- Trabalharemos em um projeto de uma clínica médica fictícia. Temos uma empresa chamada Voll Med, que possui uma clínica que precisa de um aplicativo para monitorar o cadastro de médicos, pacientes e agendamento de consultas.

- Será um aplicativo com algumas opções, em que a pessoa que for usar pode fazer o CRUD, tanto de médicos quanto de pacientes e o agendamento e cancelamento das consultas.

- A documentação das funcionalidades do projeto ficará em um quadro do Trello com cada uma das funcionalidades. Em cada cartão teremos a descrição de cada funcionalidade, com as regras e validações que vamos implementar ao longo do projeto..


Link o Trello:
    https://trello.com/b/O0lGCsKb/api-voll-med

