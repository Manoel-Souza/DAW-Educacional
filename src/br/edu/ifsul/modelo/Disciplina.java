/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)//permite que esta classe seja herdada
public class Disciplina implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "Campo nome é obrigatório.") //estes processo é para mensagem
    @NotNull(message = "Campo nome não pode ser nulo.")//estes processo é para mensagem
    @Length(max = 30, message = "O nome do pessoa deve conter até {max} caracteres")//estes processo é para mensagem
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "cargaHoraria")
    private Double cargaHoraria;
    
    @Column(name = "conhecimentosMininos")
    private String conhecimentosMininos;
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> nota = new ArrayList<>();
    
    @ManyToOne
    @ForeignKey(name = "fk_curso")
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)//objeto    
    private Curso curso;
    
//    @ManyToMany
//    @JoinTable(name = "matricula", 
//	joinColumns = 
//	    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false), 
//	inverseJoinColumns = 
//	    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
//    )
//    private Set<Aluno> listaMatricula = new HashSet<>();//fazer a relação com a classe aluno sendo que é uma relação muito para muitos

    public Disciplina() {
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

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Double getCargaHoraria() {
	return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
	this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMininos() {
	return conhecimentosMininos;
    }

    public void setConhecimentosMininos(String conhecimentosMininos) {
	this.conhecimentosMininos = conhecimentosMininos;
    }

    public void addNota(Nota not){
	nota.add(not);
	not.setDisciplina(this);
    }
//    
    public void removeNota(Nota not){
	nota.remove(not);
    }

    public void removeNota(int index){
	nota.remove(index);
    }

    public Curso getCurso() {
	return curso;
    }

    public void setCurso(Curso curso) {
	this.curso = curso;
    }
    
    @Override
    public int hashCode() {
	int hash = 5;
	hash = 79 * hash + Objects.hashCode(this.id);
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
	final Disciplina other = (Disciplina) obj;
	if (!Objects.equals(this.id, other.id)) {
	    return false;
	}
	return true;
    }   
        
}
