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