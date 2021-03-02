package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.services.ContratoDAO;
import cobranca.services.ClienteDAO;
import cobranca.services.ServicoDAO;

public class AcaoSalvaContratos {
	private HttpServletRequest req;
	
	public AcaoSalvaContratos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Contrato boleto = new Contrato();
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		Servico servico = new Servico();
		ServicoDAO servicoDao = new ServicoDAO();
		
		String valor = req.getParameter("input-valor");
		String idCliente = req.getParameter("cbx-cliente");
		String idServico = req.getParameter("cbx-servico");
		boleto.setValor(Double.parseDouble(valor));
		
		cliente = clienteDao.get(idCliente);
		servico = servicoDao.getServico(Long.parseLong(idServico));
		
		boleto.setCliente(cliente);
		boleto.setServico(servico);
		
		
		ContratoDAO dao = new ContratoDAO();
		dao.salvar(boleto);
		
		String pagina = new AcaoListagemContratos(req).executa();
		return pagina;
	}
}
