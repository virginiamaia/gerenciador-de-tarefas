package com.sistema.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.gerenciador.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
	
	@Query("SELECT t  FROM Tarefas t "
			+ "WHERE (t.titulo LIKE CONCAT('%',:titulo,'%') "
			+ "OR t.descricao LIKE CONCAT('%',:titulo,'%')) "
			+ "OR (t.responsavel = :responsavel "
			+ "AND t.prioridade = :prioridade "
			+ "AND t.id = :id)")
	public List<Tarefas> buscarTarefas(
			@Param("titulo") String titulo, 
			@Param("responsavel") String responsavel, 
			@Param("prioridade") String prioridade, 
			@Param("id") long id);
}
