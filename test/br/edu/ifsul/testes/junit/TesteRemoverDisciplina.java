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
 * * @author Manoel Souza
 */
public class TesteRemoverDisciplina {
    
    EntityManager em;
    public TesteRemoverDisciplina() {
    }
    
    @After
    public void tearDown() {
	em.close();
    }
    
    @Before
    public void setUp() {
	em = EntityManagerUtil.getEntityManager();
    }
    
    @Test
    public void teste(){
	Disciplina disc = em.find(Disciplina.class, 1);
	em.getTransaction().begin();
	em.remove(disc);
	em.getTransaction().commit();
    }
    
}
