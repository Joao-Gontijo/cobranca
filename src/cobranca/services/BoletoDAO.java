package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Boleto;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
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
		Boleto existente = getBoleto(boleto.getCodigo());
		if(existente == null) {
			em.persist(boleto);
		} else {
			existente.setCodigo(boleto.getCodigo());
			existente.setValor(boleto.getValor());
			existente.setCliente(boleto.getCliente());
			existente.setServico(boleto.getServico());
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void excluir(Boleto boleto) {
		em.getTransaction().begin();
		boleto = em.find(Boleto.class, boleto.getCodigo());
		em.remove(boleto);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Boleto> lista(){
		TypedQuery<Boleto> qry = em.createQuery("from Boleto", Boleto.class);
		return qry.getResultList();
	}
	
	public Boleto getBoleto(String codigo) {
		return em.find(Boleto.class, codigo);
	}
	
	public static void main(String[] args) {
		BoletoDAO dao = new BoletoDAO();
		ClienteDAO cdao = new ClienteDAO();
		ServicoDAO sdao = new ServicoDAO();
		
		Cliente cliente = new Cliente("d", "e", "f", "g", "h", "j", "k", "l", "m");
		
		Servico servico = new Servico("a");
		Boleto boleto = new Boleto("1", "aaa", 0, cliente, servico);
		
		cdao.salvar(cliente);
		sdao.salvar(servico);
		dao.salvar(boleto);
		
	}
}
