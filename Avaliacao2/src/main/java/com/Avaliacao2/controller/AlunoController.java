package com.Avaliacao2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Avaliacao2.Service.AlunoService;
import com.Avaliacao2.entities.Aluno;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/Aluno") 
public class AlunoController {
	private final AlunoService AlunoService; 

	@Autowired 
	public AlunoController(AlunoService AlunoService) { 
		this.AlunoService = AlunoService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){ 
		Aluno Aluno = AlunoService.getAlunoById(id); 
		if (Aluno != null) { 
			return ResponseEntity.ok(Aluno); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	public ResponseEntity<List<Aluno>> buscaTodosAlunosControl(){ 
		List<Aluno> Aluno = AlunoService.getAllAluno(); 
		return ResponseEntity.ok(Aluno); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Aluno> salvaAlunosControl(@RequestBody @Valid Aluno Aluno){ 
		Aluno salvaAluno = AlunoService.salvarAluno(Aluno); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Aluno> alteraAlunosControl(@PathVariable Long id, @RequestBody @Valid Aluno Aluno){ 
		Aluno alteraAluno = AlunoService.updateAluno(id, Aluno); 
		if (alteraAluno != null) { 
			return ResponseEntity.ok(Aluno); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){ 
		boolean apagar = AlunoService.deleteAluno(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 


