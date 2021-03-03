package cobranca.controlador.acao.cliente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

public class AcaoListagemClientes {

	private HttpServletRequest req;
	public AcaoListagemClientes(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		List<Cliente> lista = new ClienteDAO().lista();
		req.setAttribute("clientes", lista);
		return "clientes.jsp";
	}

}

