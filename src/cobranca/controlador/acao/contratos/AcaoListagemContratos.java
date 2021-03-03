package cobranca.controlador.acao.contratos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDAO;

public class AcaoListagemContratos {
	
	private HttpServletRequest req;
	public AcaoListagemContratos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		List<Contrato> lista = new ContratoDAO().lista();
		req.setAttribute("contratos", lista);
		return "contratos.jsp";
	}
}
