# javaCrudJdbc

Este é um projeto Java que realiza operações básicas de CRUD (Create, Read, Update, Delete) da entidade "Aluno" em um banco de dados PostgreSQL usando JDBC.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados (entre parênteses com asterisco estão as versões que utilizei, outras versões também podem funcionar.):

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (*17)
- [PostgreSQL](https://www.postgresql.org/download/) (*16)
- [Driver JDBC do PostgreSQL no projeto](https://jdbc.postgresql.org/) (*42.7.3)

## Configuração do Banco de Dados

1. Instale o PostgreSQL seguindo as instruções no [site oficial](https://www.postgresql.org/download/).
2. Crie um banco de dados no PostgreSQL para ser utilizado pelo projeto.
3. Vá na classe ConnectionFactory e altere os atributos `url`, `user` e `password` para as suas configurações no pgAdmin.
````
└───src
    │
    ├───factories
    │       ConnectionFactory.java
````
4. Abra o arquivo `script.sql`. Execute esse script no seu banco de dados recém-criado para criar a tabela necessária.
````
└───src
    └───sql
            script.sql
````
## Funcionamento
A interação do usuário com o projeto é através da classe Scanner, com o usuário digitando no console. Na classe ``Program.java`` tem uma expressão switch case. Selecionando as operações de 1 a 5, o sistema é levado ao método correspondente em ``AlunoController.java``.

Esses métodos de controle possuem algumas etapas:

1. Pegam dados digitados no console pelo usuário (com exceção do método "consultarAlunos")
2. É chamado um método de ``AlunoRepository.java`` que executa a operação interagindo com o banco de dados.
3. O método de controle exibe uma mensagem informativa ou retorna dados do próprio banco.