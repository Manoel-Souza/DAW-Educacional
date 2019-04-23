/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * * @author Manoel Souza
 */
@Entity
public class Aluno implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "Campo nome é obrigatório.") //estes processo é para mensagem
    @NotNull(message = "Campo nome não pode ser nulo.")//estes processo é para mensagem
    @Length(max = 30, message = "O nome do pessoa deve conter até {max} caracteres")//estes processo é para mensagem
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @ManyToMany
    @JoinTable(name = "matricula", 
	joinColumns = 
	    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false), 
	inverseJoinColumns = 
	    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    )
    private Set<Disciplina> listaMatriculam = new HashSet<>();//fazer a relação com a classe Disciplina sendo que é uma relação muito para muitos

    public Aluno() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Calendar getNascimento() {
	return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
	this.nascimento = nascimento;
    }
    
     public void adicionarDisciplinaMatricula(Disciplina d){
	listaMatriculam.add(d);	
    }
    
    public void removerDisciplinaMatricula(Disciplina d){
	listaMatriculam.remove(d);
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 31 * hash + Objects.hashCode(this.id);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Aluno other = (Aluno) obj;
	if (!Objects.equals(this.id, other.id)) {
	    return false;
	}
	return true;
    }
    
    
}
