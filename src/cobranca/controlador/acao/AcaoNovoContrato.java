package cobranca.controlador.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.services.ClienteDAO;
import cobranca.services.ServicoDAO;

public class AcaoNovoContrato {
	private HttpServletRequest req;
	
	public AcaoNovoContrato(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
//		String cnpj = req.getParameter("cnpj");
//		
//		Cliente cliente = new ClienteDAO().get(cnpj);
		List<Cliente> cliente = new ClienteDAO().lista();
		List<Servico> servico = new ServicoDAO().lista();
		
		req.setAttribute("servico", servico);
		req.setAttribute("cliente", cliente);
		
		return "cadastro-contratos.jsp";
	}
}
