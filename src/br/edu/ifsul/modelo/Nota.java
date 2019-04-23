/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Entity
public class Nota implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
   
    @Column(name = "nota1", nullable = false, columnDefinition = "numeric(10,2)")
    @Min(value = 0, message = "A nota não pode ser negativo")
    private Double nota1;
    
    @Column(name = "nota2", nullable = false, columnDefinition = "numeric(10,2)")
    @Min(value = 0, message = "A nota não pode ser negativo")
    private Double nota2;
     
    @Column(name = "media", nullable = false, columnDefinition = "numeric(10,2)")
    @Min(value = 0, message = "A nota não pode ser negativo")
    private Double media;
    
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)//objeto
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)//objeto
    @ForeignKey(name = "fk_disciplina")
    private Disciplina disciplina;

    public Nota() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
    
    public Double getNota1() {
	return nota1;
    }

    public void setNota1(Double nota1) {
	this.nota1 = nota1;
    }

    public Double getNota2() {
	return nota2;
    }

    public void setNota2(Double nota2) {
	this.nota2 = nota2;
    }

    public Double getMedia() {
	return media;
    }

    public void setMedia(Double media) {
	this.media = media;
    }
    
    public Aluno getAluno() {
	return aluno;
    }

    public void setAluno(Aluno aluno) {
	this.aluno = aluno;
    }
    
    public void calculaMedia(){
	media=(nota1+nota2)/2;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 19 * hash + Objects.hashCode(this.id);
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
	final Nota other = (Nota) obj;
	if (!Objects.equals(this.id, other.id)) {
	    return false;
	}
	return true;
    }

    public Disciplina getDisciplina() {
	return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
	this.disciplina = disciplina;
    }
    
}
