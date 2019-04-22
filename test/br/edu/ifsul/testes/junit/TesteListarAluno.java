/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteListarAluno {
    
    EntityManager em;
    public TesteListarAluno() {
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
	// o teste não deve gerar exceção se tudo estiver correto
	boolean exception = false;
	try {
	    String jpql = "from Aluno order by nome";
//	    List<Aluno> lista = em.createQuery("from Pais order by id").getResultList();
	    List<Aluno> lista = em.createQuery(jpql).getResultList();
	    for (Aluno a : lista) {
	     System.out.println("ID: " + a.getId() + ", NOME: " + a.getNome() + ", DATA NASCIMETNO: " + a.getNascimento() + ", EMAIL" + a.getEmail());
	    }
	    
	} catch (Exception e) {
	     e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
