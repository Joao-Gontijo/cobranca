package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDAO;

public class AcaoExcluirContrato {
	
	private HttpServletRequest req;
	
	public AcaoExcluirContrato(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		Contrato contrato = new Contrato();
		String idString = req.getParameter("id");
		
		Long id = Long.parseLong(idString);
		contrato.setId(id);
		new ContratoDAO().excluir(contrato);
		String pagina = new AcaoListagemContratos(req).executa();
		return pagina;
	}
}
