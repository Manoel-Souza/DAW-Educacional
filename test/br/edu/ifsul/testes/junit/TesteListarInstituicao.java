/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Instituicao;
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
public class TesteListarInstituicao {
    
    EntityManager em;
    public TesteListarInstituicao() {
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
	    List<Instituicao> lista = em.createQuery("from Instituicao order by nome").getResultList();
	    for (Instituicao inst : lista) {
	     System.out.println("ID: " + inst.getId() + ", NOME: " + inst.getNome() + ", ANOFUNCACAO: " + inst.getAnoFundacao());
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
	
    }
    
}
