package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.services.BoletoDAO;

public class AcaoExcluirBoleto {
	
	private HttpServletRequest req;
	
	public AcaoExcluirBoleto(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		Boleto boleto = new Boleto();
		String codigo = req.getParameter("codigo");
		
		boleto.setCodigo(codigo);
		new BoletoDAO().excluir(boleto);
		String pagina = new AcaoListagemBoletos(req).executa();
		return pagina;
	}
}
