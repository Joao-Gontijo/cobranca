package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.services.BoletoDAO;

public class AcaoCarregaDadosBoleto {
	private HttpServletRequest req;
	
	public AcaoCarregaDadosBoleto(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		String codigo = req.getParameter("codigo");
		Boleto boleto = new BoletoDAO().getBoleto(codigo);
		req.setAttribute("boleto", boleto);
		return "cadastro-boletos.jsp";
	}
}
