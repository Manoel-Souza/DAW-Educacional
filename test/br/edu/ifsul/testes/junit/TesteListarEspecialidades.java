/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidades;
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
public class TesteListarEspecialidades {
    
    EntityManager em;
    public TesteListarEspecialidades() {
    }
    
    @Before
    public void setUp() {
	em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teste(){
	// o teste não deve gerar exceção se tudo estiver correto
	boolean exception = false;
	try {
	    List<Especialidades> lista = em.createQuery("from Especialidades order by nome").getResultList();
	    for (Especialidades esp : lista) {
	     System.out.println("ID: " + esp.getId() + ", NOME: " + esp.getNome());
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
	
    }
    
}
