# Instruções

## Resumo

* Implemetação de um módulo de um sistema de gestão de tarefas com as funcionalidades de _CRUD_ 

* Ultização do _Spring Boot_, _Primefaces_, _JSF_, _JPA_, _POSTGRESQL_. Deploy no _Heroku_


## Itens implementados

a) Criar uma aplicação Java Web utilizando JavaServer Faces (JSF) **OK**

b) Utilizar persistência em um banco de dados PostgreSQL. **OK**

c) Utilizar JPA **OK**

e) Publicar projeto no heroku ou outro ambiente cloud. **OK**

f) outros diferenciais que julgar conveniente.
 - Spring boot
 - Primefaces

   Sendo implementadas as seguintes ações nas tarefas:
**Criar, Remover e Listar tarefas**

## Execução local

* No arquivo `src/main/resources/aplication.properties` mudar o valor do atributo `spring.profiles.active` de `prod` para `local`

* Acessar `localhost:8081/h2-console`
    - Informar usuário `sa` e senha `password`

    - Executar o script:

```sql
DROP TABLE IF EXISTS tarefas;

CREATE TABLE tarefas (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  responsavel VARCHAR(255) NOT NULL,
  prioridade VARCHAR(255) NOT NULL,
  deadline DATE NOT NULL
);

INSERT INTO tarefas (titulo, descricao, responsavel, prioridade, deadline) VALUES
  ('Tarefa1', 'desc1', 'responsavel1', 'prioridade1', TO_DATE('17-09-2012', 'dd-MM-yyyy')),
  ('Tarefa2', 'desc2', 'responsavel2', 'prioridade2', TO_DATE('17-09-2012', 'dd-MM-yyyy')),
  ('Tarefa3', 'desc3', 'responsavel3', 'prioridade3', TO_DATE('17-09-2012', 'dd-MM-yyyy'));
```

* Clicar com o botão direito do mouse no arquivo `src/main/java/com.sistema.gerenciador.GerenciadorDeTarefasApplication` e executar como Java Application
 * Acessar a aplicação em `localhost:8081/pages/index.jsf`
