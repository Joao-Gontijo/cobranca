package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

import cobranca.util.Utilitario;

public class AcaoSalvaClientes {

	private HttpServletRequest req;

	public AcaoSalvaClientes(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		Utilitario util = new Utilitario();
		Cliente cliente = new Cliente();
		
		String id = null;
		id = req.getParameter("id");

		System.out.println("ID: " + id);
		if (util.isNumeric(id)) {
			cliente.setId(Long.parseLong(id));
		}
		
		String cnpj = req.getParameter("input-cnpj");
		System.out.println(cnpj);

		String nome = req.getParameter("input-nome");
		String nomeFantasia = req.getParameter("input-nomeFantasia");
		String cep = req.getParameter("input-cep");
		String logradouro = req.getParameter("input-logradouro");
		String numero = req.getParameter("input-numero");
		String complemento = req.getParameter("input-complemento");
		System.out.println(complemento);
//		String uf = req.getParameter("cbx-uf");
//		String municipio = req.getParameter("cbx-municipio");
//		Cliente cliente = new Cliente(cnpj, nome, nomeFantasia, cep, logradouro, numero, 
//				complemento, uf, municipio);
		cliente.setCnpj(cnpj);
		cliente.setNome(nome);
		cliente.setNomeFantasia(nomeFantasia);
		cliente.setCep(cep);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		
		String pagina = new AcaoListagemClientes(req).executa();
		return pagina;
	}
	
	//id to load is required for loading ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO 
	
}