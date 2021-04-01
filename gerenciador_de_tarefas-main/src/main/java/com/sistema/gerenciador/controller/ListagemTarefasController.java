package com.sistema.gerenciador.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.gerenciador.model.Tarefas;
import com.sistema.gerenciador.repository.TarefasRepository;

@Named
@ViewScoped
public class ListagemTarefasController {
	
	@Autowired
	private TarefasRepository tarefasRepository; 
	
	private Tarefas tarefas = new Tarefas();
	
	private List<Tarefas> listagemTarefas;

	private Map<String, String> responsavelOptionsMap;
	
	private Map<String, String> prioridadeOptionsMap;
	
	@PostConstruct
	public void init() {
		setListagemTarefas(tarefasRepository.findAll());
	}
	
	public ListagemTarefasController() {
		responsavelOptionsMap = new LinkedHashMap<>();
		
		responsavelOptionsMap.put("Virginia", "Virginia");
		responsavelOptionsMap.put("Ana", "Ana");
		responsavelOptionsMap.put("Joao", "Joao");
		responsavelOptionsMap.put("Maria", "Maria");
		responsavelOptionsMap.put("Bruno", "Bruno");
		responsavelOptionsMap.put("Antonio", "Antonio");
		
		prioridadeOptionsMap = new LinkedHashMap<>();
		
		prioridadeOptionsMap.put("Alta", "Alta");
		prioridadeOptionsMap.put("Baixa", "Baixa");
		prioridadeOptionsMap.put("Média", "Média");		
	}
	
	public void buscar() {
		setListagemTarefas(tarefasRepository.buscarTarefas(
				tarefas.getTitulo(), tarefas.getResponsavel(), tarefas.getPrioridade(), tarefas.getId()));
		for (Tarefas t : listagemTarefas) {
			System.out.println(t.toString());
		}
	}
	
	public void excluir(Tarefas tarefa) {
		tarefasRepository.delete(tarefa);
		listagemTarefas.remove(tarefa);
	}
	
	public void editar(Tarefas tarefa) {
		setTarefas(tarefa);
	}

	public Tarefas getTarefas() {
		return tarefas;
	}

	public void setTarefas(Tarefas tarefas) {
		this.tarefas = tarefas;
	}
	
	public Map<String, String> getResponsavelOptionsMap() {
		return responsavelOptionsMap;
	}
	
	public Map<String, String> getPrioridadeOptionsMap() {
		return prioridadeOptionsMap;
	}

	public List<Tarefas> getListagemTarefas() {
		return listagemTarefas;
	}

	public void setListagemTarefas(List<Tarefas> listagemTarefas) {
		this.listagemTarefas = listagemTarefas;
	}
}