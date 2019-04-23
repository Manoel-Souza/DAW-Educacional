/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)//permite que esta classe seja herdada
public class Curso implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "Campo nome é obrigatório.") //estes processo é para mensagem
    @NotNull(message = "Campo nome não pode ser nulo.")//estes processo é para mensagem
    @Length(max = 30, message = "O nome do pessoa deve conter até {max} caracteres")//estes processo é para mensagem
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "sigla")
    private String sigla;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar inicioAtividades;
    
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)//objeto
    private Instituicao instituicao;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disciplina> disciplina = new ArrayList<>();

    public Curso() {
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

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }
    
    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
    
    public Boolean getAtivo() {
	return ativo;
    }

    public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
	return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
	this.inicioAtividades = inicioAtividades;
    }

    public Instituicao getInstituicao() {
	return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
	this.instituicao = instituicao;
    }
    
    public void addDisciplina(Disciplina dis){
	disciplina.add(dis);
	dis.setCurso(this);
    }
//    
    public void removeDisciplina(Disciplina dis){
	disciplina.remove(dis);
    }

    public void removeDisciplina(int index){
	disciplina.remove(index);
    }
    
    @Override
    public int hashCode() {
	int hash = 3;
	hash = 83 * hash + Objects.hashCode(this.id);
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
	final Curso other = (Curso) obj;
	if (!Objects.equals(this.id, other.id)) {
	    return false;
	}
	return true;
    }
    
}
