package com.Avaliacao2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Avaliacao2.Repository.TurmaRepository;
import com.Avaliacao2.entities.Turma;


@Service
public class TurmaService {
	
	private final TurmaRepository turmaRepository;
	
	@Autowired
	public TurmaService (TurmaRepository TurmaRepository) {
		this.turmaRepository = TurmaRepository;
	}
	
	    public List<Turma> getAllTurma() {
	        return turmaRepository.findAll();
	    }

	    public Turma getTurmaById(Long id) {
	        Optional<Turma> Turma = turmaRepository.findById(id);
	        return Turma.orElse(null);
	    }

	    public Turma salvarTurma(Turma Turma) {
	        return turmaRepository.save(Turma);
	    }

	    public Turma updateTurma(Long id, Turma updatedTurma) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	            updatedTurma.setId(id);
	            return turmaRepository.save(updatedTurma);
	        }
	        return null;
	    }
	    public boolean deleteTurma(Long id) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	        	turmaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}