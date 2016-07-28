# Curso - Java e JPA: Persista seus objetos com a JPA2 e Hibernate

## Annotations
### `@Entity`
Anotação para tornar a classe OO em uma entidade associada.
### `@Id`
Indica que atributo esta relacionado a chave primária da tabela.
> `@GeneratedValue` é uma anotação opcional que complementa o `@Id`, com ela indicamos que o banco deve atribuir o valor da chave e não a aplicação no momento da inserção de um registro.

_Exemplo_:

```
// MySQL
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

// PostgreSQL
@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")

```

## Dialect
A definição do dialect permite que o Hibernate faça o cruzamento de suas funções com as funções do banco de dados utilizado.
* **Oracle 10g**: org.hibernate.dialect.Oracle10gDialect
* **Microsoft SQL Server 2008**: org.hibernate.dialect.SQLServerDialect
* **MySQL 5.1**: org.hibernate.dialect.MySQL5InnoDBDialect
* **PostgresSQL 8.3.7**: org.hibernate.dialect.PostgreSQLDialect
* **DB2 9.1**: org.hibernate.dialect.DB2Dialect
* **Sybase ASE 15**: org.hibernate.dialect.SybaseASE15Dialect
* **HSQLDB**: org.hibernate.dialect.HSQLDialect

### ``

### ``
