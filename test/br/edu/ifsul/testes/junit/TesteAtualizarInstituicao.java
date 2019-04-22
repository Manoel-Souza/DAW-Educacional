/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Instituicao;
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
 */
public class TesteAtualizarInstituicao {
    
    EntityManager em;
    public TesteAtualizarInstituicao() {
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
	    Instituicao inst = em.find(Instituicao.class, 1);
	    inst.setNome("Instituto Federal");
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date dtN = sdf.parse("12/11/2000");
	    Calendar dtC = Calendar.getInstance();
	    dtC.setTime(dtN);
	    inst.setAnoFundacao(dtC);
	    
	    em.getTransaction().begin();
	    em.merge(inst);//equivalente o update
	    em.getTransaction().commit();
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
