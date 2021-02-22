package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.services.BoletoDAO;
import cobranca.services.ClienteDAO;
import cobranca.services.ServicoDAO;

public class AcaoSalvaBoletos {
	private HttpServletRequest req;
	
	public AcaoSalvaBoletos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Boleto boleto = new Boleto();
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		Servico servico = new Servico();
		ServicoDAO servicoDao = new ServicoDAO();
		
		String codigo = req.getParameter("input-codigo");
		String valor = req.getParameter("input-valor");
		String idCliente = req.getParameter("cbx-cliente");
		String idServico = req.getParameter("cbx-servico");
		boleto.setCodigo(codigo);
		boleto.setValor(Double.parseDouble(valor));
		
		cliente = clienteDao.get(idCliente);
		servico = servicoDao.getServico(Long.parseLong(idServico));
		
		boleto.setCliente(cliente);
		boleto.setServico(servico);
		
		BoletoDAO dao = new BoletoDAO();
		dao.salvar(boleto);
		
		String pagina = new AcaoListagemBoletos(req).executa();
		return pagina;
	}
}
