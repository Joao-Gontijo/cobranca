package cobranca.controlador.acao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.entidade.Contrato;
import cobranca.services.BoletoDAO;
import cobranca.services.ContratoDAO;

public class AcaoGeraBoleto {
	
	private HttpServletRequest req;
	
	public AcaoGeraBoleto(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		String idContrato = req.getParameter("id");
		Contrato contrato = new ContratoDAO().getContrato(Long.parseLong(idContrato));
		
		Boleto boleto = new Boleto();
		boleto.setData(new Date("2000/03/03"));
		boleto.setCodigo("12345");
		boleto.setContrato(contrato);
		
		BoletoDAO bdao = new BoletoDAO();
		bdao.salvar(boleto);
		
		
		
		String pagina = new AcaoRetornaContratos(req).executa();
		return pagina;
	}
}
