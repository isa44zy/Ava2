package com.Avaliacao2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Avaliacao2.Repository.AlunoRepository;
import com.Avaliacao2.entities.Aluno;


@Service
public class AlunoService {
	
	private final AlunoRepository AlunoRepository;
	
	@Autowired
	public AlunoService (AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}
	
	    public List<Aluno> getAllAluno() {
	        return AlunoRepository.findAll();
	    }

	    public Aluno getAlunoById(Long id) {
	        Optional<Aluno> Aluno = AlunoRepository.findById(id);
	        return Aluno.orElse(null);
	    }

	    public Aluno salvarAluno(Aluno Aluno) {
	        return AlunoRepository.save(Aluno);
	    }

	    public Aluno updateAluno(Long id, Aluno updatedAluno) {
	        Optional<Aluno> existingAluno = AlunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	            updatedAluno.setId(id);
	            return AlunoRepository.save(updatedAluno);
	        }
	        return null;
	    }
	    public boolean deleteAluno(Long id) {
	        Optional<Aluno> existingAluno = AlunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	        	AlunoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}