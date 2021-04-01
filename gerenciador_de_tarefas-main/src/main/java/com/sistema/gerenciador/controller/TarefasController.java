package com.sistema.gerenciador.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.gerenciador.model.Tarefas;
import com.sistema.gerenciador.repository.TarefasRepository;

@Named
@ViewScoped
public class TarefasController {
	
	@Autowired
	private TarefasRepository tarefasRepository; 
	
	private Tarefas tarefas = new Tarefas();

	private Map<String, String> responsavelOptionsMap;
	
	private Map<String, String> prioridadeOptionsMap;
	
	public TarefasController() {
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
	
	public void salvar() {
		try {
			tarefasRepository.save(getTarefas());
			getTarefas().setTitulo("");
			getTarefas().setDescricao("");
			getTarefas().setDeadline(new Date());
			
			showSuccess();
		} catch (IllegalArgumentException e) {
			showError();
		}
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
		
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showSuccess() {
        addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro realizado com sucesso");
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro. Verifique os dados");
    }
}