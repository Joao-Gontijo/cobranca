package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Boleto;
import cobranca.jpa.util.JPAUtil;

public class BoletoDAO {

	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public BoletoDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salvar(Boleto boleto) {
		em.getTransaction().begin();
		Boleto existente = getBoleto(boleto.getId());
		if(existente == null) {
			em.persist(boleto);
		} else {
			existente.setId(boleto.getId());
			existente.setCodigo(boleto.getCodigo());
			existente.setData(boleto.getData());
			existente.setContrato(boleto.getContrato());
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void excluir(Boleto boleto) {
		em.getTransaction().begin();
		boleto = em.find(Boleto.class, boleto.getId());
		em.remove(boleto);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Boleto> lista(){
		TypedQuery<Boleto> qry = em.createQuery("from Boleto", Boleto.class);
		return qry.getResultList();
	}
	
	public Boleto getBoleto(long id) {
		return em.find(Boleto.class, id);
	}
}
