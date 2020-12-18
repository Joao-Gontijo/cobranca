package cobranca.services;	import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cobranca.entidade.Cliente;
import cobranca.entidade.Municipio;
import cobranca.entidade.Servico;
import cobranca.jpa.util.JPAUtil;

public class ServicoDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	
	public void salvar(Servico servico) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Servico existente = getServico(servico.getId());
		if(servico == null) {
			em.persist(servico);
		}else {
			existente.setNome(servico.getNome());
			em.persist(existente);
		}
		em.persist(servico);
		em.getTransaction().commit();
		em.close();
	}

	
	
	public Servico retornaServico(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Servico servicoEncontrado = new Servico();
		servicoEncontrado = em.find(Servico.class, id);
		return servicoEncontrado;
	}
	
	public ArrayList<Servico> buscar(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Servico> listaDeServicos = new ArrayList<>();

		Query query = em.createQuery("from Servico where nome ='" + nome + "'");

		listaDeServicos = (ArrayList<Servico>) query.getResultList();

		return listaDeServicos;
	}
	
	public Servico getServico(Long id) {
		return em.find(Servico.class, id);
	}
	
}
