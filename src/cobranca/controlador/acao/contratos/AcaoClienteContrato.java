package cobranca.controlador.acao.contratos;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.entidade.Contrato;
import cobranca.services.ClienteDAO;
import cobranca.services.ContratoDAO;

public class AcaoClienteContrato {
	private HttpServletRequest req;
	
	public AcaoClienteContrato(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		String cnpj = req.getParameter("cnpj");
		
		cliente = cdao.get(cnpj);
		req.setAttribute("cliente", cliente);
		
		List<Contrato> listaTemporaria = new ArrayList<Contrato>();
		ContratoDAO contratoDao = new ContratoDAO();
		
		listaTemporaria = contratoDao.lista();
		
		List<Contrato> listaDeContrato = new ArrayList<>();
		for(Contrato contrato : listaTemporaria) {
			if(contrato.getCliente().getCnpj().equals(cnpj)) {
				listaDeContrato.add(contrato);
			}
		}
		req.setAttribute("contratos", listaDeContrato);
		return "contratos.jsp";
	}
}
