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

import com.Avaliacao2.Service.TurmaService;
import com.Avaliacao2.entities.Turma;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/Turma") 
public class TurmaController {
	private final TurmaService TurmaService; 

	@Autowired 
	public TurmaController(TurmaService TurmaService) { 
		this.TurmaService = TurmaService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable Long id){ 
		Turma Turma = TurmaService.getTurmaById(id); 
		if (Turma != null) { 
			return ResponseEntity.ok(Turma); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	public ResponseEntity<List<Turma>> buscaTodosTurmasControl(){ 
		List<Turma> Turma = TurmaService.getAllTurma(); 
		return ResponseEntity.ok(Turma); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Turma> salvaTurmasControl(@RequestBody @Valid Turma Turma){ 
		Turma salvaTurma = TurmaService.salvarTurma(Turma); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Turma> alteraTurmasControl(@PathVariable Long id, @RequestBody @Valid Turma Turma){ 
		Turma alteraTurma = TurmaService.updateTurma(id, Turma); 
		if (alteraTurma != null) { 
			return ResponseEntity.ok(Turma); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id){ 
		boolean apagar = TurmaService.deleteTurma(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 


