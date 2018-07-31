# t2oo3107-connection
Conexão com banco de dados - Java OO
## Pacotes utilizados
- java.sql
** Connection, DriverManager, PreparedStatement, ResultSet, SQLException
- java.util
** Properties
## Objetivos
O Objetivo de uma conexão com banco de dados é realizar a persistêcia, a manipulação, atualização e a exclusão de dados.
## Considerações
- uma conexão é um objeto que implementa as especificações da interface Connection do pacote java.sql
- Para obter uma conexão pode-se utilizar a fábrica de conexões da classe DriverManager também do pacote java.sql através de seu método estático getConnection (para isso você irá precisar da string de conexão [ex: jdbc:mysql://localhost:3306/singleton] e de um propertie com os dados user e password utilizados para se conectar ao seu banco de dados banco)
- Antes de executar o getConnection é recomendado executar o Class.forName(""); para carregar a classe referênte ao driver do banco especificado na string de conexão [ex: com.br.mysql.jdbc.Driver].
- Com um objeto do tipo connection criado você pode utilizá-la para executar as operações básicas de CRUD que são utilizadas em todos os software que interagem com bancos de dados. (CRUD é Create-insert, Retrive-select, Update, Delete)
- Para executar comandos você deve preparar um comando sql, passar parâmetros se necessário e executar, a execução pode ser feita com execute() em casos que não precisa do retorno, executeQuery() quando precisa do retorno no caso de uma seleção, executeUpdate() no caso de Insert, Update ou Delete.
## Documentações
- Connection [https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html]
- PreparedStatment [https://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html]
# Atividades
- Crie uma classe que implemente a interface CrudInterface disponível neste projeto no pacote br.com.adrianob - a implementação desta classe deve receber por injeção de dependencia no construtor um objeto do tipo connection.
- Faça a implementação de todos os métodos exigidos pela interface.
- Crie uma classe com método main para possibilitar a execução do Crud, esta classe deve instanciar um objeto da classe criada anteriormente e executar a chamada de todos os métodos implementados.
# Importante
- Faça um fork deste repositório
- Faça um clone do seu repositório forkeado
- Faça as implementações e testes necessários
- submeta as alterações para o seu repositório forkeado
- Faça o envio de um pull request para este repositório adicionando um comentário da seguinte forma
``` 
- #ownSEU NOME COMPLETO#own
```
- O exercício será avaliado e pontuado. O Requisito inicial de avaliação é o pull request atendendo estes requisitos. 
# NÃO SERÁ ANALISADO NENHUM OUTRO CÓDIGO FONTE ENVIADO POR OUTRO MEIO ZERANDO ESTA PONTUAÇÃO.
