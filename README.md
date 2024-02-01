# Objetivos:
- O objetivo neste projeto é usarmos o Spring Boot para desenvolvermos uma API Rest, com algumas funcionalidades.
- A ideia é desenvolver um CRUD, sendo as quatro operações fundamentais das aplicações: cadastro, listagem, atualização e exclusão de informações.

- Aplicar validações das informações que chegam na nossa API, usando o Bean Validation. Depois, vamos utilizar o conceito 
- de Paginação e Ordenação das informações que a nossa API vai devolver.

# Tecnologias:
    Spring Boot 3
    Java 17
    Lombok
    MySQL/ Flyway
    JPA/Hibernate
    Maven
    Postman
    DTO (Data Transfer Object), via Java Records
    MapStruct



Faremos tudo isso usando algumas tecnologias, como Spring Boot 3, sendo a última versão disponibilizada pelo framework.
Usaremos, também, o Java 17 sendo a última versão LTS (Long-term support, em português "Suporte de longo prazo") 
que possui maior tempo de suporte disponível para o Java.

Aprenderemos a usar alguns recursos das últimas versões do Java para deixarmos o nosso código mais simples. 
Utilizaremos em conjunto com o projeto o Lombok, responsável por fazer a geração de códigos repetitivos, 
como getters, setters, toString, entre outros. Tudo via anotações para o código ficar menos verboso.

Usaremos o banco de dados MySQL para armazenar as informações da API e junto com ele utilizaremos a biblioteca Flyway. 
Isso para termos o controle do histórico de evolução do banco de dados, um conceito que chamamos de Migration.

A camada de persistência da nossa aplicação será feita com a JPA (Java Persistence API), 
com o Hibernate como implementação dessa especificação e usando os módulos do Spring Boot, para tornar esse processo o mais simples possível.

Usaremos o Maven para gerenciar as dependências do projeto, e também para gerar o build da nossa aplicação.
Por último, como focaremos na API Rest (apenas no Back-end), não teremos interface gráfica, como páginas HTML 
e nem Front-end e aplicativo mobile.

Mas para testarmos a API, usaremos o Postman, sendo uma ferramenta usada para testes em API. 
Com ela, conseguimos simular a requisição para a API e verificar se as funcionalidades implementadas estão funcionando.


# Qual é o nosso projeto?

- Trabalharemos em um projeto de uma clínica médica fictícia. Temos uma empresa chamada Voll Med, 
- que possui uma clínica que precisa de um aplicativo para monitorar o cadastro de médicos, pacientes e agendamento de consultas.

- Será um aplicativo com algumas opções, em que a pessoa que for usar pode fazer o CRUD, 
- tanto de médicos quanto de pacientes e o agendamento e cancelamento das consultas.

- A documentação das funcionalidades do projeto ficará em um quadro do Trello com cada uma das funcionalidades. 
- Em cada cartão teremos a descrição de cada funcionalidade, com as regras e validações que vamos implementar ao longo do projeto..


Link o Trello:
    https://trello.com/b/O0lGCsKb/api-voll-med

# Objetivos:
    Boas práticas na API
    Tratamento de erros
    Autenticação/Autorização
    Tokens JWT

Os objetivos deste segundo curso são: aprender boas práticas na API referente ao protocolo HTTP. 
Faremos ajustes na classe controller, para seguir as boas práticas do protocolo HTTP quanto ao retorno dos códigos HTTP e das respostas que a API devolve.

Logo após, realizaremos tratamento de erros. Eventualmente, pode ocorrer um erro na API,
e precisamos entender o que o Spring faz ao ocorrer uma exception enquanto o programa é executado, o que é devolvido como resposta para o cliente da API.

Assim, vamos personalizar esses retornos para tratar esses erros da melhor forma possível.

Após isso, focaremos na segurança, no controle de autenticação e de autorização da API. 
No curso anterior não abordamos isso, logo a nossa API está pública - qualquer pessoa pode enviar requisições para remover,
atualizar ou alterar informações da API.

Mas não é dessa forma que desejamos, precisamos ter um controle. Isso será feito na aplicação front-end, porém, 
na API precisamos ter um código que permite o usuário se autenticar, e também ter um controle de acesso de informações públicas e privadas.

Aprenderemos a aplicar isso com o Spring Security, sendo um módulo do Spring responsável por monitorar esse controle.

No caso, usaremos a autenticação fundamentada em tokens com o padrão JSON Web Token (JWT).
