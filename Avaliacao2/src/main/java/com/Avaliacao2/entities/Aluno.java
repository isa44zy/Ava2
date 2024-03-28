package com.Avaliacao2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table (name = "Aluno")
	public class Aluno {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		@Column (name = "descricao", nullable = false)
		private String cidade;
		
		@NotBlank
		@Column (name = "email", nullable = false)
		private String email;
		
		@NotBlank
		@Column (name = "nome", nullable = false)
		private String nome;
		
		@NotBlank
		@Column (name = "ra", nullable = false)
		private String ra;
		
		@NotBlank
		@Column (name = "renda", nullable = false)
		private Double renda;
		
		@NotBlank
		@Column (name = "telefone", nullable = false)
		private String telefone;
		
		@ManyToOne
		@JoinColumn(name = "id_Turma")
		private Turma turma;

}
