create table pacientes(

    id bigint not null auto_increment,
    email varchar(100) not null unique,
    nome varchar(100) not null,
    telefone varchar(20) not null,
    cpf varchar(11) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(8) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);