package cobranca.controlador.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.services.BoletoDAO;

public class AcaoListagemBoletos {
	
	private HttpServletRequest req;
	public AcaoListagemBoletos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		List<Boleto> lista = new BoletoDAO().lista();
		req.setAttribute("boletos", lista);
		return "boletos.jsp";
	}
}
