/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Nota;
import java.util.List;
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
public class TesteListarNota {
    
    EntityManager em;
    public TesteListarNota() {
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
	    List<Nota> lista = em.createQuery("from Nota order by nome").getResultList();
	    for (Nota n : lista) {
	     System.out.println("ID: " + n.getId() + ", NOME: " + n.getAluno() + ", NOTA1: " + n.getNota1()+ ", NOTA2: " + n.getNota2()  + ", MEDIA: " + n.getMedia());
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
	
    }
    
}
