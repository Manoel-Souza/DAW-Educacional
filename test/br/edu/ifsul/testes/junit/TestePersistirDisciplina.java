/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
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
	    Disciplina disc = new Disciplina();
	    
	    disc.setNome("Algoritmos");
	    disc.setDescricao("Algoritmos de programaçãom em java");
	    disc.setCargaHoraria(4.5);
	    disc.setConhecimentosMininos("Programação em java e logica de programaçao");
	    
	    
	    em.getTransaction().begin();
	    em.persist(disc);
	    em.getTransaction().commit();
	} catch (Exception e) {
	     e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
