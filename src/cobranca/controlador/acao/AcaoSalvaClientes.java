package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

public class AcaoSalvaClientes {
	
	public AcaoSalvaClientes(HttpServletRequest req) {
		String cnpj = req.getParameter("input-cnpj");
		String nome = req.getParameter("input-nome");
		String nomeFantasia = req.getParameter("input-nomeFantasia");
		String cep = req.getParameter("input-cep");
		String logradouro = req.getParameter("input-logradouro");
		String numero = req.getParameter("input-numero");
		String complemento = req.getParameter("input-complemento");
		String uf = req.getParameter("cbx-uf");
		String municipio = req.getParameter("cbx-municipio");
		Cliente cliente = new Cliente(cnpj, nome, nomeFantasia, cep, logradouro, numero, 
				complemento, uf, municipio);
		new ClienteDAO().salvar(cliente);
	}
}
