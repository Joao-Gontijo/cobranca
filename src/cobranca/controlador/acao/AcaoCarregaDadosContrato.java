package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDAO;

public class AcaoCarregaDadosContrato {
	private HttpServletRequest req;
	
	public AcaoCarregaDadosContrato(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		String id = req.getParameter("codigo");
		Contrato contrato = new ContratoDAO().getContrato(Long.parseLong(id));
		req.setAttribute("contrato", contrato);
		return "cadastro-contratos.jsp";
	}
}
