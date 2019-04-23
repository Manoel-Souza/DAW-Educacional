/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Disciplina;
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
public class TesteListarDisciplina {
    
    EntityManager em;
    public TesteListarDisciplina() {
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
	    List<Disciplina> lista = em.createQuery("from Disciplina order by nome").getResultList();
	    for (Disciplina disc : lista) {
	     System.out.println("ID: " + disc.getId() + ", NOME: " + disc.getNome() + ", DESCRICAO: " + disc.getDescricao() + ", CARGAHORARIA: " + disc.getCargaHoraria() + ", CONHECIMENTO: " + disc.getConhecimentosMininos());
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
	
    }
    
}
