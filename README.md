# Curso - Java e JPA: Persista seus objetos com a JPA2 e Hibernate

## Dialect
A definição do dialect permite que o Hibernate faça o cruzamento de suas funções com as funções do banco de dados utilizado.
* **Oracle 10g**: org.hibernate.dialect.Oracle10gDialect
* **Microsoft SQL Server 2008**: org.hibernate.dialect.SQLServerDialect
* **MySQL 5.1**: org.hibernate.dialect.MySQL5InnoDBDialect
* **PostgresSQL 8.3.7**: org.hibernate.dialect.PostgreSQLDialect
* **DB2 9.1**: org.hibernate.dialect.DB2Dialect
* **Sybase ASE 15**: org.hibernate.dialect.SybaseASE15Dialect
* **HSQLDB**: org.hibernate.dialect.HSQLDialect

## Métodos importantes da classe EntityManager
* `persist` : método para inserção de novos registros.
* `find` : método para seleção de registros persistidos.
* `merge` : método para alteração de estado da entidade permitindo sua atualização.
* `remove` : método para exclusão de registros.

## Estados do JPA
* managed: entidade sincronizada com o banco de dados - find
* transient: entidade nunca persistida no banco de dados - persit
* detached: entidade que já possuí uma representação no banco de dados - merge
* removed: entidade removida do banco de dados - remove

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

### `@Enumerated`
Anotação para configurar tipo de dados `enum`, possibilitando determinar o seu tipo de dados.

_Exemplo_:

```
// Declarando enum
public enum Sexo {
	Masculino, Feminino
}

// Uso do tipo Sexo
@Enumerated(EnumType.STRING) //determinamos o EnumType como STRING para que o Hibernate armazene no banco de dados o valor do enum como varchar
private Sexo sexo;
```

### `@Temporal`
Anotação utilizada para determinar o formato de data que será persistido.
* @Temporal(TemporalType.DATE)
* @Temporal(TemporalType.TIME)
* @Temporal(TemporalType.TIMESTAMP)

### `@OneToOne @OneToMany @ManyToOne @ManyToMany`
Anotação utilizada para especificar cardinalidade entre as entidades:
* `@OneToOne` - 1 .. 1
* `@OneToMany` - 1 .. n
* `@ManyToOne` - n .. 1
* `@ManyToMany` - n .. n

Para que o Hibernate consiga interpretar classes bidirecionais é necessário configurar a anotação da classe responsável.

_Exemplo_:

```
public class Conta {
    ...
    @OneToMany(mappedBy="conta")
    private List<Movimentacao> movimentacoes;
    ...
}
```

### Comportamentos
* _`LAZY`_ - comportamento do relacionamento `ToMany`, recupera dados dos relacionamentos somente quando são demandados economizando processamento de dados desnecessários.
* _`EAGER`_ - comportamento do relacionamento `ToMany`, sempre recupera dados dos relacionamentos.

_Exemplo_:

```
@OneToMany(mappedBy="conta", fetch=FetchType.LAZY) //default
@OneToMany(mappedBy="conta", fetch=FetchType.EAGER)
```
