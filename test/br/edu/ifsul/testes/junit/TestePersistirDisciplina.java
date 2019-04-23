/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
//import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @author Manoel Souza 
 */
public class TestePersistirDisciplina {
    
    EntityManager em;
    public TestePersistirDisciplina() {
    }
    
    @Before
    public void setUp() {
	em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
	em.close();
    }
    
    @Test
    public void teste(){
	try {
	     Aluno a = new Aluno();
	    
	    a.setNome("Marcia");
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date dtN = sdf.parse("23/02/2002");
	    Calendar dtC = Calendar.getInstance();
	    dtC.setTime(dtN);
	    a.setNascimento(dtC);	    
	    a.setEmail("luisa@gmail.com");
	    
// -----------------------------------------------------------------------------------------------------------------	    
	    
	     Nota n = new Nota();
	    
	    n.setAluno(em.find(Aluno.class, 73));
	    n.setNota1(6.00);
	    n.setNota2(7.10);
	    n.calculaMedia();//resultado da media

// -----------------------------------------------------------------------------------------------------------------	    
	    Disciplina disc = new Disciplina();
	    
	    disc.setNome("Algoritmos");
	    disc.setDescricao("Algoritmos de programaçãom em java");
	    disc.setCargaHoraria(4.5);
	    disc.setConhecimentosMininos("Programação em java e logica de programaçao");
	    disc.setCurso(em.find(Curso.class, 43));
	    
	    disc.addNota(n);
	    
// -----------------------------------------------------------------------------------------------------------------
	    
	    
	    em.getTransaction().begin();
	    em.persist(disc);
	    em.persist(a);
	    em.getTransaction().commit();
	} catch (Exception e) {
	     e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
