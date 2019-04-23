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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * * @author Manoel Souza
 */
@Entity
@Table(name = "professor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Aluno implements Serializable{ //  extensão Aluno (Herança)
    
    @Column(name = "titulacao")
    private String titulacao;
     
    @Column(name = "topicosInterresse", columnDefinition = "text") 
    private String topicosInterresse;
    
    @ManyToOne
    @JoinColumn(name = "especialidades", referencedColumnName = "id")
    private Especialidades especialidades;

    public Professor() {
    }

    public String getTitulacao() {
	return titulacao;
    }

    public void setTitulacao(String titulacao) {
	this.titulacao = titulacao;
    }

    public String getTopicosInterresse() {
	return topicosInterresse;
    }

    public void setTopicosInterresse(String topicosInterresse) {
	this.topicosInterresse = topicosInterresse;
    }

    public Especialidades getEspecialidades() {
	return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
	this.especialidades = especialidades;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 17 * hash + Objects.hashCode(this.titulacao);
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
	final Professor other = (Professor) obj;
	if (!Objects.equals(this.titulacao, other.titulacao)) {
	    return false;
	}
	return true;
    }
    
    
}
