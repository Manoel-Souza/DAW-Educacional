/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
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
public class TesteAtualizarCurso {
    
    EntityManager em;
    public TesteAtualizarCurso() {
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
	    
	    Disciplina dis = new Disciplina();
	    dis.setNome("Algoritmos");
	    dis.setNome("teste");

// -----------------------------------------------------------------------------------------------------------------
	    
	    Curso cur = em.find(Curso.class, 1);
	    
	    cur.setNome("Sistemas");
	    cur.setSigla("CS");
	    cur.setDescricao("Curso de Sistemas, para programação");
	    cur.setAtivo(Boolean.TRUE);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date dtN = sdf.parse("10/05/2019");
	    Calendar dtC = Calendar.getInstance();
	    dtC.setTime(dtN);	    
	    cur.setInicioAtividades(dtC);
	    
	    cur.setInstituicao(em.find(Instituicao.class, 1));
	    
	    cur.addDisciplina(dis);
	    
	    
	    em.getTransaction().begin();
	    em.merge(cur);//equivalente o update
	    em.getTransaction().commit();
	} catch (Exception e) {
	     e.printStackTrace();
	    System.out.println("Erro: "+e);
	}
    }
    
}
