/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidades;
import br.edu.ifsul.modelo.Professor;
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
 * * @author Manoel Souza
 */
public class TestePersistirProfessor {
    
    EntityManager em;
    public TestePersistirProfessor() {
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
	    Professor prof = new Professor();
	    
	    prof.setNome("Marcelo");
	    prof.setEmail("marcelo@gmail.com");
//	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date dtN = sdf.parse("01/08/1997");
	    Calendar dtC = Calendar.getInstance();
	    dtC.setTime(dtN);
	    prof.setNascimento(dtC);
	    
	    prof.setTitulacao("Mestre");
	    prof.setTopicosInterresse("Algoritmos");
	    prof.setEspecialidades(em.find(Especialidades.class, 1));
	    
	    em.getTransaction().begin();
	    em.persist(prof);
	    em.getTransaction().commit();
	} catch (Exception e) {
	     e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
