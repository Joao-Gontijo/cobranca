package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Contrato;
import cobranca.jpa.util.JPAUtil;

public class ContratoDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public ContratoDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salvar(Contrato contrato) {
		em.getTransaction().begin();
		Contrato existente = getContrato(contrato.getId());
		if(existente == null) {
			em.persist(contrato);
		} else {
			existente.setId(contrato.getId());
			existente.setValor(contrato.getValor());
			existente.setCliente(contrato.getCliente());
			existente.setServico(contrato.getServico());
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void excluir(Contrato contrato) {
		em.getTransaction().begin();
		contrato = em.find(Contrato.class, contrato.getId());
		em.remove(contrato);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contrato> lista(){
		TypedQuery<Contrato> qry = em.createQuery("from Contrato", Contrato.class);
		return qry.getResultList();
	}
	
	public Contrato getContrato(long id) {
		return em.find(Contrato.class, id);
	}
}
