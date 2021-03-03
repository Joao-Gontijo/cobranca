package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDAO;

public class AcaoRetornaContratos {
	private HttpServletRequest req;
	
	public AcaoRetornaContratos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		String id = req.getParameter("id");
		Contrato contrato = new ContratoDAO().getContrato(Long.parseLong(id));
		
		req.setAttribute("contrato", contrato);
		return "boletos.jsp";
	}
}
